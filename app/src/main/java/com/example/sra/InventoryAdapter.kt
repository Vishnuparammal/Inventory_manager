package com.example.sra

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


// https://stackoverflow.com/questions/58219364/kotlin-displaying-data-from-firebase-database-in-recyclerview-in-fragment
class InventoryAdapter(val context: Context, val InventoryList: ArrayList<InventoryItem>) :
    RecyclerView.Adapter<InventoryAdapter.Holder>() {

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(InventoryList[position], context)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_inventory, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return InventoryList.size
    }


    inner class Holder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val recordItemName = view?.findViewById<TextView>(R.id.item_name)
        val recordItemSpecs = view?.findViewById<TextView>(R.id.item_specs)
        val recordItemQuantity = view?.findViewById<TextView>(R.id.item_quantity)
        val recordItemLocation = view?.findViewById<TextView>(R.id.item_location)

        fun bind(item: InventoryItem, context: Context) {
            recordItemName?.text = item.itemName
            recordItemSpecs?.text = item.itemSpecs
            recordItemQuantity?.text = item.itemQuantity.toString()
            recordItemLocation?.text = item.itemLocation
        }
    }
}