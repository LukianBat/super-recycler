package com.example.myapplication

interface ItemsModel {

    interface Listener {
        fun onItemRemoved(pos: Int)
    }

    fun size(): Int

    var listener: Listener?
}

class ModifableItemsModel(
    private val model: MutableList<Data>
): ItemsModel {

    override fun size(): Int = model.size

    override var listener: ItemsModel.Listener? = null

    fun itemAt(pos: Int): Data {
        return model[pos]
    }

    fun removeItem(pos: Int) {
        model.removeAt(pos)
        listener?.onItemRemoved(pos)
    }
}