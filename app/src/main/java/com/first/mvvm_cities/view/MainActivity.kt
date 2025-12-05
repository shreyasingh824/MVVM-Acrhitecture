package com.first.mvvm_cities.view
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import com.first.mvvm_cities.databinding.ActivityMainBinding
import com.first.mvvm_cities.viewmodel.CityViewModel




class MainActivity : AppCompatActivity() {

//    private val model : CityViewModel by viewModels ()
    private lateinit var viewmodel : CityViewModel

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
       viewmodel = ViewModelProvider(this).get(CityViewModel::class.java)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()

        viewmodel.getCityData().observe(this, { city ->
            binding.citiImage.setImageDrawable(
                ResourcesCompat.getDrawable(resources, city.img, applicationContext.theme)
            )
            binding.cityName.text = city.name
            binding.population.text = city.population.toString()
        }   )
        }
    }
