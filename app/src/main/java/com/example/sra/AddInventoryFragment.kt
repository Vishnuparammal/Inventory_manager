package com.example.sra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.sra.databinding.FragmentAddInventoryBinding
import com.google.firebase.database.FirebaseDatabase


class AddInventoryFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentAddInventoryBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_inventory, container, false)
        // Write a message to the database
        binding.addItem.setOnClickListener(){

            // use data binding
            val itemName = binding.itemName.text.toString()
            val itemSpecs = binding.itemSpecs.text.toString()
            val itemQuantity = binding.itemQuantity.text.toString().toInt()
            val itemLocation = binding.itemLocation.text.toString()
            // Write a message to the database
            val database = FirebaseDatabase.getInstance().getReference("Inventory").child("$itemName $itemSpecs")

            database.setValue(  InventoryItem(itemName, itemSpecs, itemQuantity, itemLocation)  )

            binding.itemName.setText("")
            binding.itemSpecs.setText("")
            binding.itemQuantity.setText("")
            binding.itemLocation.setText("")
        }

        return binding.root
    }


}