package com.example.challenge2.adapter

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.R
import com.example.challenge2.models.ItemMakanan

class FoodAdapter(private val foods: List<ItemMakanan>):RecyclerView.Adapter<FoodAdapter.FoodHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    interface OnItemClickCallback {
        fun onItemClicked(data:ItemMakanan)

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback=onItemClickCallback
    }

    class FoodHolder(view: View):RecyclerView.ViewHolder(view){
        val image:ImageView=view.findViewById(R.id.imageMakanan)
        val tvName:TextView=view.findViewById(R.id.tvNama)
        val tvHarga:TextView=view.findViewById(R.id.tvHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        return FoodHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_makanan,parent,false))
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        holder.image.setImageResource(foods[position].image)
        holder.tvName.text=foods[position].name
        holder.tvHarga.text=foods[position].harga.toString()
    }

    override fun getItemCount(): Int {
        return foods.size
    }
}