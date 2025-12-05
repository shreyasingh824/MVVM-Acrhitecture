package com.first.mvvm_cities.viewmodel

import android.app.Application
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.first.mvvm_cities.model.CityDataProvider
import com.first.mvvm_cities.model.city
import java.io.Closeable


class CityViewModel(application: Application) : AndroidViewModel(application) {

    private val citydata = MutableLiveData<city>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2000L

    init {
        loop()
        Log.d("application debug" , application.toString())
    }

    private fun loop() {
        Handler(Looper.getMainLooper()).postDelayed({ updateCity() }, delay)
    }

    private fun updateCity() {
        currentIndex++
        currentIndex %= cities.size

        citydata.value = cities[currentIndex]
        loop()


    }
    fun getCityData() = citydata

}



