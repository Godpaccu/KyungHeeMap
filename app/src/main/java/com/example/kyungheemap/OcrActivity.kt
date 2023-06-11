package com.example.kyungheemap

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.Text
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.korean.KoreanTextRecognizerOptions
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader


class OcrActivity : AppCompatActivity() {
    private lateinit var ocrTextView: TextView
    private val galleryRequestCode = 123
    private var selectedImageUri: Uri? = null
    private var visionText: Text? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ocractivity)
        ocrTextView = findViewById(R.id.textView)

        val prev = findViewById<Button>(R.id.prev_button)
        prev.setOnClickListener {
            val intent = Intent(this,Settings::class.java)
            startActivity(intent)
            finish()
        }


        val jsonArrayFileName = "crawlOut.json"
        val objects = convertJSONArrayToObjects(jsonArrayFileName)

        // 개별 객체 출력
        for (obj in objects) {
            println(obj)
        }

        // OCR 결과 확인
        checkOCRResults(objects)

        val runOCRButton: Button = findViewById(R.id.button)
        runOCRButton.setOnClickListener {
            processImage()
        }
    }
    // OCR 결과 확인 함수
    private fun checkOCRResults(objects: List<JSONObject>) {
        val ocrResult = ocrTextView.text.toString().trim()
        val ocrLines = ocrResult.split("\n")
        val ocrLineCount = ocrLines.size

        for (i in 0 until ocrLineCount step 2) {
            if (i + 1 < ocrLineCount) {
                val name = ocrLines[i].trim()
                val classInfo = ocrLines[i + 1].trim()

                val matchingObject = objects.find { obj ->
                    val objName = obj.optString("name", "")
                    val objClass = obj.optString("class", "")
                    ocrResult.contains(objName) && ocrResult.contains(objClass)
                }

                if (matchingObject != null) {
                    val name = matchingObject.optString("name", "")
                    val prof = matchingObject.optString("prof", "")
                    val time = matchingObject.optString("time", "")
                    val classRoom = matchingObject.optString("class", "")

                    val info = "Name: $name\nProfessor: $prof\nTime: $time\nClass: $classRoom\n"

                    println("OCR 된 텍스트가 요소에 포함되어 있습니다: $info")
                } else {
                    println("OCR 된 텍스트가 요소에 포함되어 있지 않습니다: $name, $classInfo")
                }
            }
        }
    }

    private val galleryLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK && result.data != null) {
                val selectedImageUri: Uri? = result.data?.data
                // 선택된 이미지를 사용하여 필요한 작업을 수행합니다.
                if (selectedImageUri != null) {
                    recognizeText(selectedImageUri)
                }
            }
        }

    private fun processImage() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        galleryLauncher.launch(galleryIntent)
    }

    private fun recognizeText(selectedImageUri: Uri) {
        val imageBitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, selectedImageUri)
        val imageWidth = imageBitmap.width
        val sectionWidth = imageWidth / 5

        val recognizer = TextRecognition.getClient(KoreanTextRecognizerOptions.Builder().build())

        // Divide the image horizontally into 5 sections
        val ocrResults = mutableListOf<String>() // OCR 결과를 저장할 리스트

        val totalSections = 5
        var completedSections = 0

        // Callback 함수를 정의하여 OCR 결과를 수집하고 처리
        val processOcrCallback = { sectionOcrResult: String ->
            val processedResult = if (sectionOcrResult.endsWith("공")) {
                if (sectionOcrResult.length >= 2) {
                    sectionOcrResult.substring(0, sectionOcrResult.length - 1) + "\n"
                } else {
                    sectionOcrResult
                }
            } else {
                sectionOcrResult
            }

            ocrResults.add(processedResult) // OCR 결과 저장

            completedSections++
            if (completedSections == totalSections) {
                // 마지막 섹션까지 OCR 완료되었을 때, 결과를 처리
                processCombinedOcrResult(ocrResults)
            }
        }


        // Divide the image and perform OCR on each section
        for (i in 0 until totalSections) {
            val left = i * sectionWidth
            val right = left + sectionWidth

            // Crop the image section
            val sectionBitmap =
                Bitmap.createBitmap(imageBitmap, left, 0, sectionWidth, imageBitmap.height)

            val image: InputImage = InputImage.fromBitmap(sectionBitmap, 0)

            // Perform OCR on the section image
            val result = recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    // Handle OCR result for each section
                    val sectionOcrResult = extractOcrResult(visionText)
                    processOcrCallback(sectionOcrResult) // OCR 결과를 처리하는 콜백 함수 호출

                }
                .addOnFailureListener { e ->
                    // Handle OCR failure for each section
                    processOcrCallback("") // OCR 실패 시 빈 결과를 처리하는 콜백 함수 호출
                }
        }
    }
    private fun extractOcrResult(visionText: Text): String {
        val ocrResult = StringBuilder()
        var previousLineText = ""

        for (block in visionText.textBlocks) {
            for (line in block.lines) {
                val lineText = line.text.trim()

                if (lineText.endsWith("공")) {
                    ocrResult.append(lineText)
                    continue
                } else {
                    ocrResult.append(lineText)
                }

                ocrResult.append("\n")
                previousLineText = lineText
            }
        }

        return ocrResult.toString().trim()
    }


    public fun processCombinedOcrResult(ocrResults: List<String>) {
        val combinedResult = StringBuilder()
        val lines = ocrResults[0].split("\n")
        val AdividedLines = mutableListOf<String>()

        var i = 0
        while (i < lines.size) {
            val line = StringBuilder(lines[i++])
            if (i < lines.size && lines[i].isNotBlank()) {
                line.append("\n").append(lines[i++])
            }
            AdividedLines.add(line.toString())
        }

        for (line in AdividedLines) {
            println(line)
        }
        val dividedLines = AdividedLines.map { it.replace("\n", "-") }
        ocrTextView.text = dividedLines.toString()
        val intent = Intent(this, ShowActivity::class.java)
        intent.putStringArrayListExtra("dividedLines", ArrayList(dividedLines))
        intent.putStringArrayListExtra("AdividedLines", ArrayList(AdividedLines))
        startActivity(intent)
    }




    fun convertJSONArrayToObjects(jsonArrayFileName: String): List<JSONObject> {
        val objects = mutableListOf<JSONObject>()

        try {
            val inputStream = assets.open(jsonArrayFileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val jsonString = reader.use { it.readText() }

            val jsonArray = JSONArray(jsonString)


            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                objects.add(jsonObject)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return objects


    }
}

class ShowActivity : AppCompatActivity() {
    private lateinit var label_1: TextView
    private lateinit var label_2: TextView
    private lateinit var label_3: TextView
    private lateinit var label_4: TextView
    private lateinit var label_5: TextView
    private lateinit var label_6: TextView
    private lateinit var label_7: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.showlabel)
        label_1 = findViewById(R.id.textView1)
        label_2 = findViewById(R.id.textView2)
        label_3 = findViewById(R.id.textView3)
        label_4 = findViewById(R.id.textView4)
        label_5 = findViewById(R.id.textView5)
        label_6 = findViewById(R.id.textView6)
        label_7 = findViewById(R.id.textView7)

        savedInstanceState?.let {
            label_1.text = it.getString("label_1_text", "No divided lines")
            label_2.text = it.getString("label_2_text", "No divided lines")
            label_3.text = it.getString("label_3_text", "No divided lines")
            label_4.text = it.getString("label_4_text", "수업이 없습니다")
            label_5.text = it.getString("label_5_text", "수업이 없습니다")
            label_6.text = it.getString("label_6_text", "수업이 없습니다")
            label_7.text = it.getString("label_7_text", "수업이 없습니다")
        }

        val SplitInfo  = ArrayList<String>()
        val dividedLines = intent.getStringArrayListExtra("dividedLines")
        val AdividedLines = intent.getStringArrayListExtra("AdividedLines")
        if (AdividedLines != null) {
            for (aLine in AdividedLines) {
                var SplitLine = aLine.split("\n")
                var lvl = SplitLine[1]
                SplitInfo.addAll(SplitLine)
            }
        }
        // intent로 콜하는데 넘기는 클래스 이름은 m1foor, 전달되는 인수는 스트링으로 m176_3
        val dividedLinesSize = dividedLines?.size ?: 0

        label_1.text = if (dividedLinesSize > 0) dividedLines?.get(0) else "No divided lines"
        label_1.setOnClickListener {
            var floorNumber = Character.getNumericValue(SplitInfo[1][1])
            val intent = when (floorNumber) {
                1 -> Intent(this, m1floor::class.java)
                2 -> Intent(this, m2floor::class.java)
                3 -> Intent(this, m3floor::class.java)
                4 -> Intent(this, m4floor::class.java)
                5 -> Intent(this, m5floor::class.java)
                6 -> Intent(this, m6floor::class.java)
                else -> null
            }

            intent?.apply {
                putExtra("class", SplitInfo[1] )
                startActivity(this)
            }
        }
        label_2.text = if (dividedLinesSize > 1) dividedLines?.get(1) else "No divided lines"
        label_2.setOnClickListener {
            var floorNumber = Character.getNumericValue(SplitInfo[3][1])
            val intent = when (floorNumber) {
                1 -> Intent(this, m1floor::class.java)
                2 -> Intent(this, m2floor::class.java)
                3 -> Intent(this, m3floor::class.java)
                                4 -> Intent(this, m4floor::class.java)
                                5 -> Intent(this, m5floor::class.java)
                                6 -> Intent(this, m6floor::class.java)
                else -> null
            }
            intent?.apply {
                putExtra("class", SplitInfo[3] )
                startActivity(this)
            }
        }
        label_3.text = if (dividedLinesSize > 2) dividedLines?.get(2) else "No divided lines"
        label_3.setOnClickListener {
            var floorNumber = Character.getNumericValue(SplitInfo[5][1])
            val intent = when (floorNumber) {
                1 -> Intent(this, m1floor::class.java)
                2 -> Intent(this, m2floor::class.java)
                3 -> Intent(this, m3floor::class.java)
                                4 -> Intent(this, m4floor::class.java)
                                5 -> Intent(this, m5floor::class.java)
                                6 -> Intent(this, m6floor::class.java)
                else -> null
            }
            intent?.apply {
                putExtra("class", SplitInfo[5] )
                startActivity(this)
            }
        }
        label_4.text = if (dividedLinesSize > 3) dividedLines?.get(3) else "수업이 없습니다"
        label_4.setOnClickListener {
            var floorNumber = Character.getNumericValue(SplitInfo[7][1])
            val intent = when (floorNumber) {
                1 -> Intent(this, m1floor::class.java)
                2 -> Intent(this, m2floor::class.java)
                3 -> Intent(this, m3floor::class.java)
                4 -> Intent(this, m4floor::class.java)
                5 -> Intent(this, m5floor::class.java)
                6 -> Intent(this, m6floor::class.java)
                else -> null
            }
            intent?.apply {
                putExtra("class", SplitInfo[7] )
                startActivity(this)
            }
        }
        label_5.text = if (dividedLinesSize > 4) dividedLines?.get(4) else "수업이 없습니다"
        label_5.setOnClickListener {
            var floorNumber = Character.getNumericValue(SplitInfo[9][1])
            val intent = when (floorNumber) {
                1 -> Intent(this, m1floor::class.java)
                2 -> Intent(this, m2floor::class.java)
                3 -> Intent(this, m3floor::class.java)
                4 -> Intent(this, m4floor::class.java)
                5 -> Intent(this, m5floor::class.java)
                6 -> Intent(this, m6floor::class.java)
            else -> null
            }
            intent?.apply {
                putExtra("class", SplitInfo[9] )
                startActivity(this)
            }
        }
        label_6.text = if (dividedLinesSize > 5) dividedLines?.get(5) else "수업이 없습니다"
        label_6.setOnClickListener {
            var floorNumber = Character.getNumericValue(SplitInfo[11][1])
            val intent = when (floorNumber) {
                1 -> Intent(this, m1floor::class.java)
                2 -> Intent(this, m2floor::class.java)
                3 -> Intent(this, m3floor::class.java)
                4 -> Intent(this, m4floor::class.java)
                5 -> Intent(this, m5floor::class.java)
                6 -> Intent(this, m6floor::class.java)
                else -> null
            }
            intent?.apply {
                putExtra("class", SplitInfo[9] )
                startActivity(this)
            }
        }
        label_7.text = if (dividedLinesSize > 6) dividedLines?.get(6) else "수업이 없습니다"
        label_7.setOnClickListener {
            var floorNumber = Character.getNumericValue(SplitInfo[13][1])
            val intent = when (floorNumber) {
                1 -> Intent(this, m1floor::class.java)
                2 -> Intent(this, m2floor::class.java)
                3 -> Intent(this, m3floor::class.java)
                4 -> Intent(this, m4floor::class.java)
                5 -> Intent(this, m5floor::class.java)
                6 -> Intent(this, m6floor::class.java)
                else -> null
            }
            intent?.apply {
                putExtra("class", SplitInfo[13] )
                startActivity(this)
            }
        }

        fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            // 상태 저장
            outState.putString("label_1_text", label_1.text.toString())
            outState.putString("label_2_text", label_2.text.toString())
            outState.putString("label_3_text", label_3.text.toString())
            outState.putString("label_4_text", label_4.text.toString())
            outState.putString("label_5_text", label_5.text.toString())
            outState.putString("label_6_text", label_6.text.toString())
            outState.putString("label_7_text", label_7.text.toString())
        }


    }
}