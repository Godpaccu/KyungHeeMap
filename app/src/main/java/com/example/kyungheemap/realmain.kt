package com.example.kyungheemap


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kyungheemap.ui.theme.KyungHeeMapTheme



class realmain1 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1stfloor)
        val button = findViewById<Button>(R.id.m176_3)
        button.setOnClickListener {
            val intent = Intent(this@realmain1, m1floor::class.java)
            startActivity(intent)
        }
    }
}
class m1floor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1stfloor)
        val back= findViewById<ImageView>(R.id.imageView14)
        back.setOnClickListener {
            val intent = Intent(this@m1floor, MainActivity2::class.java)
            startActivity(intent)
        }
        val to2 = findViewById<Button>(R.id.button8)
        to2.setOnClickListener {
            val intent = Intent(this@m1floor, m2floor::class.java)
            startActivity(intent)
        }
        val to3 = findViewById<Button>(R.id.button9)
        to3.setOnClickListener {
            val intent = Intent(this@m1floor, m3floor::class.java)
            startActivity(intent)
        }
    }
}
class m2floor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2ndfloor)
        val back= findViewById<ImageView>(R.id.imageView15)
        back.setOnClickListener {
            val intent = Intent(this@m2floor, MainActivity2::class.java)
            startActivity(intent)
        }
        val to1 = findViewById<Button>(R.id.button10)
        to1.setOnClickListener {
            val intent = Intent(this@m2floor, m1floor::class.java)
            startActivity(intent)
        }
        val to3 = findViewById<Button>(R.id.button18)
        to3.setOnClickListener {
            val intent = Intent(this@m2floor, m3floor::class.java)
            startActivity(intent)
        }
    }
}
class m3floor : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3rdfloor)
        val back= findViewById<ImageView>(R.id.imageView16)
        back.setOnClickListener {
            val intent = Intent(this@m3floor, MainActivity2::class.java)
            startActivity(intent)
        }
        val to2 = findViewById<Button>(R.id.button23)
        to2.setOnClickListener {
            val intent = Intent(this@m3floor, m2floor::class.java)
            startActivity(intent)
        }
        val to1 = findViewById<Button>(R.id.button19)
        to1.setOnClickListener {
            val intent = Intent(this@m3floor, m1floor::class.java)
            startActivity(intent)
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