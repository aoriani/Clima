@file:JvmName("WeatherIcon")
package com.io.clima.ui

import androidx.annotation.DrawableRes
import com.io.clima.R
import com.io.clima.network.Weather
import com.io.clima.network.Weather.Condition.*

@JvmName("fromCondition")
@DrawableRes
fun Weather.Condition.toIcon(): Int {
 return when(this) {
     Thunderstorm -> R.drawable.thunderstorm
     Drizzle -> R.drawable.drizzle
     Rain -> R.drawable.rainy
     Snow -> R.drawable.snow
     Mist -> R.drawable.mist
     Smoke -> R.drawable.smoky
     Haze -> R.drawable.haze
     Fog -> R.drawable.fog
     Tornado -> R.drawable.tornado
     Sunny -> R.drawable.sunny
     Cloudy -> R.drawable.cloud
     Other -> R.drawable.weather_mix
 }
}