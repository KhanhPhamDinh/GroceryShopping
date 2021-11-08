package com.example.groceryshopping

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.groceryshopping.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
//    lateinit var toggle : ActionBarDrawerToggle
    lateinit var bottomNavigation: BottomNavigationView
    private lateinit var _binding: ActivityHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        setSupportActionBar(_binding.myToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bottomNavigation = _binding.bottomNavigation
        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> replaceFragment(R.id.homeFragment, item.title.toString() )
                R.id.nav_search -> replaceFragment(R.id.search_fragment, item.title.toString() )
                R.id.nav_bookmark -> replaceFragment(R.id.bookmark_fragment, item.title.toString())
            }
            true
        }

        // Get the navigation host fragment from this Activity
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // Instantiate the navController using the NavHostFragment
        navController = navHostFragment.navController
        // Make sure actions in the ActionBar get propagated to the NavController
        setupActionBarWithNavController(navController)

    }

    private fun replaceFragment(id: Int, title: String){
        navController.navigate(id)
        setTitle(title)
    }

    fun setActionBarTitle(title: String) {
        supportActionBar!!.title = title
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(toggle.onOptionsItemSelected(item))
//            return true

        when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(applicationContext, "Clicked search", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_filter -> {
                Toast.makeText(applicationContext, "Clicked filter", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_notification -> {
                Toast.makeText(applicationContext, "Clicked notification", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}