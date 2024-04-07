package com.example.praveen_barath_comp304_lab_4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.praveen_barath_comp304_lab_4.databinding.ActivityMapBinding
import kotlin.properties.Delegates


class MapActivity : AppCompatActivity(), OnMapReadyCallback {
    @SuppressLint("MissingInflatedId", "SetTextI18n")

    private lateinit var mapView: MapView
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapBinding
    private var latitude by Delegates.notNull<Double>()
    private var longitude by Delegates.notNull<Double>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        /*
        Only to show in TextView which is not required.
        Replace with your code.
        This is just to get data from previous activity
        */
//        val tvMap11: TextView = findViewById(R.id.tvMap1)
//        val tvMap22: TextView = findViewById(R.id.tvMap2)

        /*
        Do not replace.
        This code is important. You will require these data
        It is Type, Address, Latitude and longitude
        This data we got from previous activity
        */
        var landmarkType = intent.getStringExtra("TYPE")
        var landmarkName = intent.getStringExtra("LANDMARK_NAME")
        var landmarkAddress = intent.getStringExtra("ADDRESS")
        latitude = intent.getDoubleExtra("LATITUDE", 0.0)
        longitude= intent.getDoubleExtra("LONGITUDE", 0.0)

        /*
        Do not replace.
        This data is important. It converts Latitude and longitude into Double
        This data we got from previous activity
        */


        /*
        Only to show in TextView which is not required.
        Replace with your code.
        This is just to get data from previous activity
        */
//        findViewById<TextView>(R.id.tvMap1).text = "$landmarkName\n$landmarkAddress"
//        findViewById<TextView>(R.id.tvMap2).text = "Latitude: $latitude\nLongitude: $longitude"
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Retrieve latitude and longitude from intent


        val location = LatLng(latitude, longitude)
        mMap.addMarker(MarkerOptions().position(location).title("Marker"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }


}