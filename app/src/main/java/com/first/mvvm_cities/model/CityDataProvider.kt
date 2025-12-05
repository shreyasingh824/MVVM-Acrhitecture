package com.first.mvvm_cities.model

import com.first.mvvm_cities.R

class CityDataProvider {
    private val cities = arrayListOf<city>()
    init{
        //here _ are space for clearity
        cities.add(city("Bangkok", R.drawable.bangkok, 10_000_000))
        cities.add(city("Beijing", R.drawable.beijing, 21_500_000))
        cities.add(city("London", R.drawable.london, 8_900_000))
        cities.add(city("New York", R.drawable.newyork, 10_000_000))
        cities.add(city("Paris", R.drawable.bangkok, 10_000_000))
        cities.add(city("Rio de Janeiro", R.drawable.rio, 10_000_000))
        cities.add(city("Rome", R.drawable.rome, 10_000_000))
        cities.add(city("Singapore", R.drawable.singapore, 10_000_000))
        cities.add(city("Tokyo", R.drawable.tokyo, 10_000_000))

    }

    fun getCities() = cities

}