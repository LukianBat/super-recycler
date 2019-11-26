package com.example.myapplication

class ItemsPresenter(
    private val model: ModifableItemsModel
) {

    private val actionsImpl = object : OneItemView.Actions {
        override fun onRemoveClicked(pos: Int) {
            model.removeItem(pos)
        }
    }

    fun model(): ItemsModel = model

    fun bind(view: OneItemView, pos: Int) {
        view.bind(model.itemAt(pos))

        if (view.actions == null) {
            view.actions = actionsImpl
        }
    }
}
