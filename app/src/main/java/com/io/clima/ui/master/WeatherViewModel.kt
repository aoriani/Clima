package com.io.clima.ui.master

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.io.clima.network.Weather

class WeatherViewModel: ViewModel() {
    private val _items = MutableLiveData<List<Weather>>(emptyList())
    val items: LiveData<List<Weather>> = _items


}