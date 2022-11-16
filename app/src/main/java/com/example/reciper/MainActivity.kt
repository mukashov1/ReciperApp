package com.example.reciper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navBar)
        setupWithNavController(bottomNavigationView , navController)

//        replaceFragment(Home())
//        val navBar = findViewById<BottomNavigationView>(R.id.navBar)
//        navBar.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.search -> replaceFragment(Search())
//                R.id.home -> replaceFragment(Home())
//                R.id.saved -> replaceFragment(Saved())
//                R.id.profile -> replaceFragment(Profile())
//                else -> {
//                    replaceFragment(Home())
//                }
//            }
//
//            true
//        }


    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frameLayout , fragment)
//        fragmentTransaction.commit()
//    }

}