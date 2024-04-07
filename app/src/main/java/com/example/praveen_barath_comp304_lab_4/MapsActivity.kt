package com.example.praveen_barath_comp304_lab_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.praveen_barath_comp304_lab_4.databinding.ActivityMapBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.praveen_barath_comp304_lab_4.databinding.ActivityMapsBinding
import com.google.android.gms.maps.MapView
import kotlin.properties.Delegates

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var latitude :Double = 0.0
    private var longitude :Double = 0.0
    private lateinit var  landmarkName : String
    private lateinit var  landmarkAddress : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.maps) as SupportMapFragment
        mapFragment.getMapAsync(this)

        var landmarkType = intent.getStringExtra("TYPE")
        landmarkName = intent.getStringExtra("LANDMARK_NAME").toString()
        landmarkAddress = intent.getStringExtra("ADDRESS").toString()
        val latString = intent.getStringExtra("LATITUDE")
        val longString = intent.getStringExtra("LONGITUDE")

        val lat: Double? = latString?.toDoubleOrNull()
        val long: Double? = longString?.toDoubleOrNull()


        if (lat != null && long != null) {
            latitude = lat
            longitude = long
        } else {
            println("Invalid latitude or longitude")
        }


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val location = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(location).title("$landmarkName $landmarkAddress $latitude $longitude"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }




}