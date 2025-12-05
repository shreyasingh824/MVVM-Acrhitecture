package com.first.mvvm_cities.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.first.mvvm_cities.R
import com.first.mvvm_cities.databinding.ActivityMainBinding
import com.first.mvvm_cities.viewmodel.CityViewModel
import com.first.mvvm_cities.model.city



class MainActivity : AppCompatActivity() {

    private val model : CityViewModel by viewModels ()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this, { city ->
            binding.citiImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )
            binding.cityName.text = city.name
            binding.population.text = city.population.toString()
        }   )

        }

    }
