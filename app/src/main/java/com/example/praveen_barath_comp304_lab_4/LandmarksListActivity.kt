package com.example.praveen_barath_comp304_lab_4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class LandmarksListActivity : AppCompatActivity(), LandmarkAdapter.RecyclerViewEvent {

    private var landmarkList = ArrayList<Landmark>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landmarks_list)

//        landmarkList.add(Landmark("CN Tower", "   30 Bloor Street\n   Toronto, ON", "111", "1000"))
//        landmarkList.add(Landmark("Centennial College", "   30 Bloor Street\n   Toronto, ON", "222", "2000"))
//        landmarkList.add(Landmark("Toronto Zoo", "   30 Bloor Street\n   Toronto, ON", "333", "3000"))
//        landmarkList.add(Landmark("Nathan Phillips Square", "   30 Bloor Street\n   Toronto, ON", "444", "4000"))
//        landmarkList.add(Landmark("Kensington Market", "   30 Bloor Street\n   Toronto, ON", "555", "5000"))

        var landmarkType = intent.getStringExtra("LANDMARK_TYPE")
        landmarkType.toString()

        val tvLandmarkType: TextView = findViewById(R.id.tvToronto4)
        tvLandmarkType.text = landmarkType

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView1)
        recyclerView.adapter = LandmarkAdapter(getLandmarksByType(landmarkType), this)
        //recyclerView.adapter = LandmarkAdapter(landmarkList, this)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onItemClick(position: Int) {
        var landmarkType = intent.getStringExtra("LANDMARK_TYPE")
        landmarkType.toString()
        val landmark = getLandmarksByType(landmarkType)[position]
        Toast.makeText(this, landmark.latitude, Toast.LENGTH_LONG).show()
        val intent = Intent(this@LandmarksListActivity, MapsActivity::class.java)
        intent.putExtra("TYPE", landmarkType)
        intent.putExtra("LANDMARK_NAME", landmark.name)
        intent.putExtra("ADDRESS", landmark.address)
        intent.putExtra("LATITUDE", landmark.latitude)
        intent.putExtra("LONGITUDE", landmark.longitude)
        startActivity(intent)
    }

    fun getLandmarksByType(type: String?): List<Landmark> {
        val landmarks = mutableListOf<Landmark>()

        when (type) {
            "Attractions" -> {
                landmarks.add(Landmark("CN Tower", "    301 Front St W,\n    Toronto, ON", "43.6426", "-79.3871" ) )
                landmarks.add(Landmark("Ripley's Aquarium of Canada", "    288 Bremner Blvd,\n    Toronto, ON", "43.6424", "-79.3860" ) )
                landmarks.add(Landmark("Hockey Hall of Fame", "    30 Yonge St,\n    Toronto, ON", "43.6466", "-79.3776" ) )
            }
            "Museums" -> {
                landmarks.add(Landmark("Royal Ontario Museum", "    00 Queens Park,\n    Toronto, ON", "43.6677", "-79.3948" ) )
                landmarks.add(Landmark("Art Gallery of Ontario", "    317 Dundas St W,\n    Toronto, ON", "43.6536", "-79.3925" ) )
                landmarks.add(Landmark("Ontario Science Centre", "    770 Don Mills Rd,\n    North York, ON", "43.7161", "-79.3392" ) )
            }
            "Stadiums" -> {
                landmarks.add(Landmark("Scotiabank Arena", "    40 Bay St,\n    Toronto, ON", "43.6437", "-79.3791" ) )
                landmarks.add(Landmark("Rogers Centre", "    1 Blue Jays Way,\n    Toronto, ON", "43.6414", "-79.3894" ) )
                landmarks.add(Landmark("BMO Field", "    170 Princes' Blvd,\n    Toronto, ON", "43.6332", "-79.4183" ) )
            }
            "Old Buildings" -> {
                landmarks.add(Landmark("Casa Loma", "    1 Austin Terrace,\n    Toronto, ON", "43.6780", "-79.4094" ) )
                landmarks.add(Landmark("St. Lawrence Hall", "    157 King St E,\n    Toronto, ON", "43.6482", "-79.3718" ) )
                landmarks.add(Landmark("Distillery District", "    55 Mill St,\n    Toronto, ON", "43.6509", "-79.3592" ) )
            }
            "Parks" -> {
                landmarks.add(Landmark("High Park", "    1873 Bloor St W,\n    Toronto, ON", "43.6465", "-79.4638" ) )
                landmarks.add(Landmark("Toronto Islands", "    9 Queens Quay W,\n    Toronto, ON", "43.6216", "-79.3744" ) )
                landmarks.add(Landmark("Edwards Gardens", "    755 Lawrence Ave E,\n    North York, ON", "43.7321", "-79.3690" ) )
            }
            else -> {

            }
        }

        return landmarks
    }


}