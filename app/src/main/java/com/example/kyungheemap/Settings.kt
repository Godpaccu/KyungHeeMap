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

class Settings : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        val button = findViewById<ImageView>(R.id.ocrbutton)
        button.setOnClickListener {
            val intent = Intent(this@Settings, Settings::class.java)//수정
            startActivity(intent)
        }
        val button2 = findViewById<Button>(R.id.viewscf)
        button2.setOnClickListener {
            val intent = Intent(this@Settings, m1floor::class.java)//수정
            startActivity(intent)
        }
    }

    @Composable
    fun Greeting3(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview3() {
        KyungHeeMapTheme {
            Greeting3("Android")
        }
    }
}
