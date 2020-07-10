package com.example.sra
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.sra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//          setContentView(R.layout.activity_main)
            val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
            val navController = this.findNavController(R.id.myNavHostFragment)
            NavigationUI.setupActionBarWithNavController(this, navController)

            // Declaring that our Fragment has a Menu

    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }



}