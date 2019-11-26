package com.example.myapplication

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder private constructor(
    private val view: ItemView
): RecyclerView.ViewHolder(view.view),
    OneItemView
{

    companion object {
        fun create(context: Context, parent: ViewGroup): MyViewHolder {
            return MyViewHolder(
                ItemView.create(context, parent)
            )
        }
    }

    override var actions: OneItemView.Actions? = null

    init {
        view.actions = object : ItemView.Actions {
            override fun onRemoveClicked() {
                actions?.onRemoveClicked(adapterPosition)
            }
        }
    }

    override fun bind(item: Data) {
        view.bind(item)
    }
}