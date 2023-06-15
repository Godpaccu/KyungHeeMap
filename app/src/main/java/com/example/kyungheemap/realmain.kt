package com.example.kyungheemap


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kyungheemap.ui.theme.KyungHeeMapTheme
import androidx.core.content.ContextCompat
import android.content.Context
import org.json.JSONArray
import org.json.JSONObject
import kotlin.reflect.full.memberProperties

fun getVariableName(variable: Any): String {
    val properties = variable.javaClass.kotlin.memberProperties

    for (property in properties) {
        if (property.get(variable) === variable) {
            return property.name
        }
    }

    return "null"
}
fun readJsonFromAssets(context: Context, classes:String): String {
    val jsonFile = context.assets.open("crawlOut.json")
    val jsonString = jsonFile.bufferedReader().use { it.readText() }
    val jsonArray = JSONArray(jsonString)

    val resultList = mutableListOf<Map<String, String>>()

    for (i in 0 until jsonArray.length()) {
        val jsonObject = jsonArray.getJSONObject(i)
        val name = jsonObject.getString("name")
        val prof = jsonObject.getString("prof")
        val time = jsonObject.getString("time")
        val classValue = jsonObject.getString("class")
        if(classValue!=classes){
            continue
        }
        if(name=="") {
            continue
        }
        val resultMap = mapOf(
            "name" to name,
            "prof" to prof,
            "time" to time,
            "class" to classValue
        )

        resultList.add(resultMap)
    }
    val stringBuilder = StringBuilder()
    for (i in resultList) {
        stringBuilder.append(i["name"])
            .append(": ")
            .append(i["prof"])
            .append(":: ")
            .append(i["time"])
            .append("\n")
    }
    val returns = stringBuilder.toString()
    return returns
}
fun getClass(context: Context,variable:Any):String{
    var Str= getVariableName(variable)
    var StrFixed="공"+Str[1]+Str[2]+Str[3]+"-"+Str[5]+"호"
    //m176_3
    return readJsonFromAssets(context,StrFixed)
}


class zum1floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1stfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this, m6floor::class.java)
            startActivity(intent)
            finish()
        }
        val viewlabel=findViewById<TextView>(R.id.viewlabels)
        val m176_3=findViewById<Button>(R.id.m176_3)
        val m167=findViewById<Button>(R.id.m167)
        val m163=findViewById<Button>(R.id.m163)
        val m129=findViewById<Button>(R.id.m129)
        val m107=findViewById<Button>(R.id.m107)
        m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
        viewlabel.text="\n\n\n건축디지털디자인기초:이영석,금 10:30~13:15\n건축BIM:백장운,화 15:00~16:15\n공학프로그래밍입문:윤정호,화 09:00~10:15"
        m176_3.setOnClickListener {
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n건축디지털디자인기초:이영석,금 10:30~13:15\n건축BIM:백장운,화 15:00~16:15\n공학프로그래밍입문:윤정호,화 09:00~10:15"}

        m167.setOnClickListener {
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n첨단나노소재연구실"}
        m163.setOnClickListener {
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n공과대학학생회실"}
        m129.setOnClickListener {
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n핵자기공명분광계실"}
        m107.setOnClickListener {
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n세미나실"}
    }
}
class m1floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1stfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this, m6floor::class.java)
            startActivity(intent)
            finish()
        }
        val viewlabel=findViewById<TextView>(R.id.viewlabels)
        val m176_3=findViewById<Button>(R.id.m176_3)
        val m167=findViewById<Button>(R.id.m167)
        val m163=findViewById<Button>(R.id.m163)
        val m129=findViewById<Button>(R.id.m129)
        val m107=findViewById<Button>(R.id.m107)
        val m104=findViewById<Button>(R.id.m104)
        m104.setOnClickListener {
            m104.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n김곤 교수연구실"}

        m167.setOnClickListener {
            m104.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n첨단나노소재연구실"}
        m163.setOnClickListener {
            m104.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n공과대학학생회실"}
        m129.setOnClickListener {
            m104.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n핵자기공명분광계실"}
        m107.setOnClickListener {
            m104.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m107.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m129.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m163.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            m167.backgroundTintList = ContextCompat.getColorStateList(this,R.color.nFFyellow)
            viewlabel.text="\n\n\n세미나실"}
    }
}
class m2floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2ndfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this, m6floor::class.java)
            startActivity(intent)
            finish()
        }

    }
}
class m3floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3rdfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this@m3floor, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this@m3floor, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this@m3floor, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this@m3floor, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this@m3floor, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this@m3floor, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this@m3floor, m6floor::class.java)
            startActivity(intent)
            finish()
        }
        val viewlabel=findViewById<TextView>(R.id.viewlabels)
        val m371=findViewById<Button>(R.id.m371)
        m371.setOnClickListener {
            m371.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            viewlabel.text="\n\n\n열역학:홍희기,화 16: 화 09: 00~10: 15\n재료역학:이경업,수 16: 30~19: 15\n"
        }
    }
}
class zum3floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3rdfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this@zum3floor, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this@zum3floor, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this@zum3floor, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this@zum3floor, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this, m6floor::class.java)
            startActivity(intent)
            finish()
        }
        val viewlabel=findViewById<TextView>(R.id.viewlabels)
        val m371=findViewById<Button>(R.id.m371)
            m371.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            viewlabel.text="\n\n\n열역학:홍희기,화 16: 화 09: 00~10: 15\n재료역학:이경업,수 16: 30~19: 15\n"

    }
}
class m4floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4thfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this@m4floor, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this@m4floor, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this@m4floor, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this@m4floor, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this@m4floor, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this@m4floor, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this@m4floor, m6floor::class.java)
            startActivity(intent)
            finish()
        }

    }
}
class m5floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_5thfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this@m5floor, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this@m5floor, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this@m5floor, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this@m5floor, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this@m5floor, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this@m5floor, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this@m5floor, m6floor::class.java)
            startActivity(intent)
            finish()
        }

    }
}
class m6floor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_6thfloor)
        val back= findViewById<Button>(R.id.button_back)
        back.setOnClickListener {
            val intent = Intent(this@m6floor, MainActivity2::class.java)
            startActivity(intent)
            finish()
        }
        val to1 = findViewById<Button>(R.id.button_one)
        to1.setOnClickListener {
            val intent = Intent(this@m6floor, m1floor::class.java)
            startActivity(intent)
            finish()
        }
        val to2 = findViewById<Button>(R.id.button_two)
        to2.setOnClickListener {
            val intent = Intent(this@m6floor, m2floor::class.java)
            startActivity(intent)
            finish()
        }
        val to3 = findViewById<Button>(R.id.button_three)
        to3.setOnClickListener {
            val intent = Intent(this@m6floor, m3floor::class.java)
            startActivity(intent)
            finish()
        }
        val to4 = findViewById<Button>(R.id.button_four)
        to4.setOnClickListener {
            val intent = Intent(this@m6floor, m4floor::class.java)
            startActivity(intent)
            finish()
        }
        val to5 = findViewById<Button>(R.id.button_five)
        to5.setOnClickListener {
            val intent = Intent(this@m6floor, m5floor::class.java)
            startActivity(intent)
            finish()
        }
        val to6 = findViewById<Button>(R.id.button_six)
        to6.setOnClickListener {
            val intent = Intent(this@m6floor, m6floor::class.java)
            startActivity(intent)
            finish()
        }

    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    KyungHeeMapTheme {
        Greeting2("Android")
    }
}
