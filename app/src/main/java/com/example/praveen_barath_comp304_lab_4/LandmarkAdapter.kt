package com.example.praveen_barath_comp304_lab_4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class LandmarkAdapter(
    private val data: List<Landmark>,
    private val listner: RecyclerViewEvent
) : RecyclerView.Adapter<LandmarkAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val tvName: TextView = view.findViewById(R.id.tv1)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress2)
        val tvLat: TextView = view.findViewById(R.id.tv2)
        val tvLong: TextView = view.findViewById(R.id.tv3)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listner.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflatedView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ItemViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val landmark: Landmark = data[position]

        holder.tvName.text = landmark.name
        holder.tvAddress.text = landmark.address
        holder.tvLat.text = landmark.latitude
        holder.tvLong.text = landmark.longitude
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface RecyclerViewEvent {
        fun onItemClick(position: Int)
    }


}