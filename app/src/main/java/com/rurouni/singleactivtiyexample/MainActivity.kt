package com.rurouni.singleactivtiyexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.rurouni.singleactivtiyexample.databinding.ActivityMainBinding
import com.rurouni.singleactivtiyexample.view.main_page.HomeFragmentDirections
import com.rurouni.singleactivtiyexample.view.main_page.ProfileFragmentDirections

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.navHostApp.id) as NavHostFragment
        navController = navHostFragment.navController

        initNavigation()
        initToolbar()
        listenNavigation()
    }

    private fun initNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeMenu -> {
                    val action = ProfileFragmentDirections.actionProfileFragmentToHomeFragment()
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.profileFragment, true)
                        .build()
                    navController.navigate(action, navOptions)
                    true
                }
                R.id.profileMenu -> {
                    val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment()
                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.homeFragment, true)
                        .build()
                    navController.navigate(action, navOptions)
                    true
                }
                else -> false
            }
        }
    }

    private fun initToolbar() {
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun listenNavigation() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when(destination.id) {
                R.id.loginFragment, R.id.signUpFragment, R.id.postFragment, R.id.settingsFragment -> binding.bottomNavigationView.visibility = View.GONE
                else -> binding.bottomNavigationView.visibility = View.VISIBLE
            }

            when(destination.id) {
                R.id.loginFragment, R.id.signUpFragment, R.id.homeFragment, R.id.profileFragment -> binding.toolbar.visibility = View.GONE
                else -> binding.toolbar.visibility = View.VISIBLE
            }
        }
    }
}