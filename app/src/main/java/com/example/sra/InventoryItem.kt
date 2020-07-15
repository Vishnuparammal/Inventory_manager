package com.example.sra

// https://stackoverflow.com/questions/58219364/kotlin-displaying-data-from-firebase-database-in-recyclerview-in-fragment
data class InventoryItem(var itemName : String = "",
                         var itemSpecs : String = "",
                         var itemQuantity : Int = 0,
                         var itemLocation : String = "")