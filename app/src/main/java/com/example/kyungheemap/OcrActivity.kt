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


class OcrActivity : AppCompatActivity() {
    private lateinit var ocrTextView: TextView
    private val galleryRequestCode = 123
    private var selectedImageUri: Uri? = null
    private var visionText: Text? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ocractivity)
        ocrTextView = findViewById(R.id.textView)

        val runOCRButton: Button = findViewById(R.id.button)

        runOCRButton.setOnClickListener {
            processImage()

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
            ocrResults.add(sectionOcrResult) // OCR 결과 저장

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
        // OCR 결과에서 텍스트 추출
        val ocrResult = StringBuilder()
        for (block in visionText.textBlocks) {
            val text = block.text
            ocrResult.append(text).append("\n")
        }
        return ocrResult.toString()
    }

    private fun processCombinedOcrResult(ocrResults: List<String>) {
        // 여기에서 5개의 OCR 결과를 한꺼번에 처리하는 로직을 구현
        // 예: 결과를 합치거나 출력하기
        val combinedResult = StringBuilder()
        for ((index, result) in ocrResults.withIndex()) {
            combinedResult.append("Section ${index + 1} OCR Result:\n")
            combinedResult.append(result)
            combinedResult.append("\n")
        }
        ocrTextView.text = combinedResult.toString()
    }
}
