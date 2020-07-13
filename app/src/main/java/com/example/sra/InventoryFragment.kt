package com.example.sra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sra.databinding.FragmentInventoryBinding
import com.google.firebase.database.FirebaseDatabase


class InventoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentInventoryBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_inventory, container, false)
        // Write a message to the database
        binding.floatingActionButton.setOnClickListener(){
            requireView().findNavController().navigate(R.id.addInventoryFragment)
        }

        return binding.root
    }

}