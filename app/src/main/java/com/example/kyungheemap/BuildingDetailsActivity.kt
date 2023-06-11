package com.example.kyungheemap
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BuildingDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        var buildingName = intent.getStringExtra("buildingName")
        if(buildingName == "공과대학"){
            setContentView(R.layout.activity_1stfloor)
        }
    }
}