package com.example.challenge2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge2.adapter.FoodAdapter
import com.example.challenge2.models.ItemMakanan
import com.example.challenge2.models.RecyclerViewLayoutOption

class MainActivity : AppCompatActivity() {
    private var _rvLayoutOption = RecyclerViewLayoutOption.LINEAR_LAYOUT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv_foods)
        rv.layoutManager=LinearLayoutManager(this)
        var fa = FoodAdapter(generateDatas(),_rvLayoutOption)
        fa.setOnItemClickCallback(object: FoodAdapter.OnItemClickCallback{
            override fun onItemClicked(data: ItemMakanan) {
                moveToDetailPage(data)
            }
        })
        rv.adapter=fa
        findViewById<ImageView>(R.id.iv_MenuOption).setImageResource(R.drawable.ic_rv_linearmenu)

        findViewById<ImageView>(R.id.iv_MenuOption).setOnClickListener{

            if(_rvLayoutOption==RecyclerViewLayoutOption.GRID_LAYOUT) {
                findViewById<ImageView>(R.id.iv_MenuOption).setImageResource(R.drawable.ic_rv_linearmenu)
                rv.layoutManager=LinearLayoutManager(this)
                _rvLayoutOption=RecyclerViewLayoutOption.LINEAR_LAYOUT
                fa.changeLayoutManager(_rvLayoutOption)
                fa.setOnItemClickCallback(object : FoodAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: ItemMakanan) {
                        moveToDetailPage(data)
                    }
                })
                //fa.notifyDataSetChanged()
                rv.adapter=fa
                //rv.invalidate()
            }
            else{
                rv.layoutManager=GridLayoutManager(this,2)
                findViewById<ImageView>(R.id.iv_MenuOption).setImageResource(R.drawable.ic_rv_gridmenu)
                _rvLayoutOption=RecyclerViewLayoutOption.GRID_LAYOUT
                fa.changeLayoutManager(_rvLayoutOption)
                fa.setOnItemClickCallback(object : FoodAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: ItemMakanan) {
                        moveToDetailPage(data)
                    }
                })
                //fa.notifyDataSetChanged()
                rv.adapter=fa
                //rv.invalidate()
            }
        }
    }

    private fun moveToDetailPage(data: ItemMakanan) {
        startActivity(Intent(this@MainActivity,DetailFoodPage::class.java).putExtra("data",data))
        Log.d("nav","Pepindahan ke detail page")
    }

    fun generateDatas(): ArrayList<ItemMakanan> {
        var datas = ArrayList<ItemMakanan>()
        for(i in 1..100){
            datas.add(ItemMakanan("makanan$i",R.drawable.food,i+1000))
        }
        return datas
    }
}