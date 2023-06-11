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
import org.json.JSONArray
import org.json.JSONObject
import java.nio.charset.Charset
import java.nio.file.Files
import java.nio.file.Paths
import androidx.core.content.ContextCompat
import android.content.Context


//// JSON 파일 읽기
//val jsonString = String(Files.readAllBytes(Paths.get()), Charset.defaultCharset())
//
//// JSON 배열 생성
//val jsonArray = JSONArray(jsonString)
//fun check(c: String): String{
//    // JSON 배열 순회
//    var str=""
//    for (i in 0 until jsonArray.length()) {
//        // JSON 객체 가져오기
//        val jsonObject = jsonArray.getJSONObject(i)
//
//        // "class" 값 확인
//        val classValue = jsonObject.getString("class")
//
//        // "class" 값에 "x"가 포함된 경우
//        if (classValue.contains(c)) {
//            // "name", "prof", "time" 값 가져오기
//            val name = jsonObject.getString("name")
//            val prof = jsonObject.getString("prof")
//            val time = jsonObject.getString("time")
//
//            // 결과 출력
//            str+="\n"+name+" "+prof+" "+" "+time
//        }
//    }
//    return str
//}
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
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            viewlabel.text="\n\n\n사회기반시스템디자인1:김성민,화 16: 30~19: 15\n건축공학프로그래밍:연문숙,수 16: 30~19: 15\n건축공학응용설계:백장운,월 16: 30~19: 15\n공정설계:원왕연,월 09: 00~10: 15"
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


        m176_3.setOnClickListener {
            m176_3.backgroundTintList = ContextCompat.getColorStateList(this,R.color.FFyellow)
            viewlabel.text="\n\n\n사회기반시스템디자인1:김성민,화 16: 30~19: 15\n건축공학프로그래밍:연문숙,수 16: 30~19: 15\n건축공학응용설계:백장운,월 16: 30~19: 15\n공정설계:원왕연,월 09: 00~10: 15"
        }
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
