package com.example.myapplication

interface OneItemView {

    interface Actions {
        fun onRemoveClicked(pos: Int)
    }

    var actions: Actions?

    fun bind(item: Data)
}
