package com.example.myapplication

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private val context: Context,
    private val presenter: ItemsPresenter
): RecyclerView.Adapter<MyViewHolder>(),
 ItemsModel.Listener
{
    private val model = presenter.model().apply {
        listener = this@MyAdapter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(context, parent)
    }

    override fun getItemCount(): Int {
        return model.size()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        presenter.bind(holder, position)
    }

    override fun onItemRemoved(pos: Int) {
        notifyItemRemoved(pos)
    }
}