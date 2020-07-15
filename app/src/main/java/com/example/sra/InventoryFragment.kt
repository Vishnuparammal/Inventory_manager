package com.example.sra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sra.databinding.FragmentInventoryBinding
import com.google.firebase.database.*


// https://stackoverflow.com/questions/58219364/kotlin-displaying-data-from-firebase-database-in-recyclerview-in-fragment
class InventoryFragment : Fragment() {

    var firedatabase : FirebaseDatabase? = null
    var InventoryList : ArrayList<InventoryItem> ? = null
    var ref : DatabaseReference? = null

    var mRecyclerView : RecyclerView? =null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentInventoryBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_inventory, container, false)

        firedatabase = FirebaseDatabase.getInstance()


        mRecyclerView = binding.recyclerView
        mRecyclerView?.setHasFixedSize(true)
        mRecyclerView?.layoutManager = LinearLayoutManager(context)


        InventoryList = arrayListOf<InventoryItem>()
        ref = FirebaseDatabase.getInstance().getReference("Inventory")


        ref?.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {


                if(p0!!.exists()){

                    for (h in p0.children){
                        val item = h.getValue(InventoryItem::class.java)
                        InventoryList?.add(item!!)
                    }

                    val adapter = InventoryAdapter(context!!, InventoryList!!)
                    mRecyclerView?.setAdapter(adapter)

                }

            }
        })

        binding.floatingActionButton.setOnClickListener(){
            requireView().findNavController().navigate(R.id.addInventoryFragment)
        }


        return binding.root
    }

}