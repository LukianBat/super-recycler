package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ItemView private constructor(
    val view: View
) {

    companion object {
        fun create(context: Context, parent: ViewGroup): ItemView {
            return ItemView(
                LayoutInflater.from(context).inflate(R.layout.view_item, parent, false)
            )
        }
    }

    interface Actions {
        fun onRemoveClicked()
    }

    var actions: Actions? = null

    private val idText = view.findViewById<TextView>(R.id.text_id)

    init {
        view.findViewById<View>(R.id.remove_btn).setOnClickListener {
            actions?.onRemoveClicked()
        }
    }


    fun bind(item: Data) {
        idText.text = item.id.toString()
    }
}