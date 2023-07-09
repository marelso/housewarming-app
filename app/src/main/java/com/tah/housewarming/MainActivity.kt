package com.tah.housewarming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.tah.housewarming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.bottomNav?.let { bottomNav ->
            binding?.container?.id?.let {
                setupWithNavController(
                    bottomNav,
                    (supportFragmentManager.findFragmentById(it) as NavHostFragment).navController
                )
            }
        }
    }
}