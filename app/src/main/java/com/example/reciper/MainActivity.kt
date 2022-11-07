package com.example.reciper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navBar = findViewById<BottomNavigationView>(R.id.navBar)
        navBar.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(home())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.profile -> replaceFragment(profile())
                else -> {

                }
            }

            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout , fragment)
        fragmentTransaction.commit()
    }

}