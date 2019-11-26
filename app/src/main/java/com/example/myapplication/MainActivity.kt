package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val presenter = ItemsPresenter(
        ModifableItemsModel(
            ArrayList<Data>().apply {
                for (i in 0..100) {
                    add(Data(i * 5))
                }
            }
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myrecycler.layoutManager = LinearLayoutManager(this)
        myrecycler.adapter = MyAdapter(this, presenter)
    }
}
