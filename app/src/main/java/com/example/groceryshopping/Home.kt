package com.example.groceryshopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Home : AppCompatActivity() {
    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        var drawerLayout : DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext, "click home", Toast.LENGTH_SHORT).show()
                R.id.nav_new_brand -> Toast.makeText(applicationContext, "click new brand", Toast.LENGTH_SHORT).show()
                R.id.nav_new_stock -> Toast.makeText(applicationContext, "click new stock", Toast.LENGTH_SHORT).show()
                R.id.nav_contact -> Toast.makeText(applicationContext, "click contact", Toast.LENGTH_SHORT).show()
                R.id.nav_log_out -> Toast.makeText(applicationContext, "click log out", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true

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