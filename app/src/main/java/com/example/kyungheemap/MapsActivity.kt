package com.example.kyungheemap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.kyungheemap.databinding.ActivityMapsBinding

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val KyungHee = LatLng(37.247066,127.078476)
        val Foreign = LatLng(37.245222,127.077713)
        val Engineering = LatLng(37.246338,127.080708)
        val Multimedia = LatLng(37.244364,127.076809)
        val Sports = LatLng(37.244334,127.080336)
        val Lifescience = LatLng(37.242860,127.080989)
        val International = LatLng(37.239791,127.081239)
        val Software = LatLng(37.239774,127.083383)
        val Design = LatLng(37.241602,127.084533)

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KyungHee, 17F))
        mMap.addMarker(MarkerOptions().position(Foreign).title("외국어대학"))
        mMap.addMarker(MarkerOptions().position(Engineering).title("공과대학"))
        mMap.addMarker(MarkerOptions().position(Multimedia).title("멀티미디어교육관"))
        mMap.addMarker(MarkerOptions().position(Sports).title("체육대학"))
        mMap.addMarker(MarkerOptions().position(Lifescience).title("생명과학대학"))
        mMap.addMarker(MarkerOptions().position(International).title("국제대학"))
        mMap.addMarker(MarkerOptions().position(Software).title("전자정보대학/소프트웨어융합대학"))
        mMap.addMarker(MarkerOptions().position(Design).title("예술디자인대학"))

        mMap.setOnMarkerClickListener { marker ->
            val buildingName = marker.title
            val intent = Intent(this@MapsActivity,BuildingDetailsActivity::class.java)
            intent.putExtra("buildingName", buildingName)
            startActivity(intent)
            true
        }
    }

}