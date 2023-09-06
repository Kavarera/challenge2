package com.example.challenge2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.adapter.FoodAdapter
import com.example.challenge2.models.ItemMakanan

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv_foods)
        rv.layoutManager=GridLayoutManager(this,2)
        val datas = ArrayList<ItemMakanan>()
        for(i in 1..10){
            datas.add(ItemMakanan("makanan$i",R.drawable.food,i+1000))
        }
        rv.adapter=FoodAdapter(datas)
    }
}