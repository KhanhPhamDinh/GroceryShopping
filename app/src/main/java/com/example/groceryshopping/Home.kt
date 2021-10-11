package com.example.groceryshopping

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.groceryshopping.databinding.ActivityHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
//    lateinit var toggle : ActionBarDrawerToggle
    lateinit var bottomNavigation: BottomNavigationView
    private lateinit var _binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        bottomNavigation = _binding.bottomNavigation
        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.nav_home -> replaceFragment(HomeFragment(), item.title.toString() )
                R.id.nav_search -> replaceFragment(SearchFragment(), item.title.toString() )
                R.id.nav_bookmark -> replaceFragment(BookmarkFragment(), item.title.toString())
            }
            true
        }

        replaceFragment(HomeFragment(), getString(R.string.title_home) )

    }

    private fun replaceFragment(fragment: Fragment, title: String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
        setTitle(title)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
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