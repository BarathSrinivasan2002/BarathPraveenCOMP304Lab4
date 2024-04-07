package com.example.praveen_barath_comp304_lab_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), LandmarkTypeAdapter.RecyclerViewListner {

    private var landmarkTypeList = ArrayList<LandmarkTypes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        landmarkTypeList.add(LandmarkTypes(R.drawable.building, "Old Buildings") )
        landmarkTypeList.add(LandmarkTypes(R.drawable.museum, "Museums") )
        landmarkTypeList.add(LandmarkTypes(R.drawable.stadium, "Stadiums") )
        landmarkTypeList.add(LandmarkTypes(R.drawable.attraction, "Attractions") )
        landmarkTypeList.add(LandmarkTypes(R.drawable.parks, "Parks") )

        val recyclerType: RecyclerView = findViewById(R.id.recyclerViewType)
        recyclerType.adapter = LandmarkTypeAdapter(landmarkTypeList, this)
        recyclerType.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(position: Int) {
        val landmarkType = landmarkTypeList[position]
        Toast.makeText(this, landmarkType.name, Toast.LENGTH_LONG).show()
        val intent = Intent(this@HomeActivity, LandmarksListActivity::class.java)
        intent.putExtra("LANDMARK_TYPE", landmarkType.name)
        startActivity(intent)
    }
}