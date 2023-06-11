package com.example.kyungheemap

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kyungheemap.ui.theme.KyungHeeMapTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)
        val button = findViewById<ImageButton>(R.id.setting)
        button.setOnClickListener {
            val intent = Intent(this@MainActivity2, Settings::class.java)
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.ec_button)
        button2.setOnClickListener {
            val intent = Intent(this@MainActivity2, m1floor::class.java)//수정
            startActivity(intent)

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
}