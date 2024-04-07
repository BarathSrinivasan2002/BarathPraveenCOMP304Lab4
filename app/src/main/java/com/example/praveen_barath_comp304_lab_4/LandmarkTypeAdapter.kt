package com.example.praveen_barath_comp304_lab_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class LandmarkTypeAdapter(
    private val landmarkData: List<LandmarkTypes>,
    private val myListner: RecyclerViewListner
) : RecyclerView.Adapter<LandmarkTypeAdapter.TypeViewHolder>() {

    inner class TypeViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val imgType: ImageView = view.findViewById(R.id.imgType)
        val tvType: TextView = view.findViewById(R.id.tvTypeName)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                myListner.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        val inflatedView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.types, parent, false)
        return TypeViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        val landmarkType: LandmarkTypes = landmarkData[position]

        holder.imgType.setImageResource(landmarkType.imgPhoto)
        holder.tvType.text = landmarkType.name
    }

    override fun getItemCount(): Int {
        return landmarkData.size
    }

    interface RecyclerViewListner {
        fun onItemClick(position: Int)
    }

}
