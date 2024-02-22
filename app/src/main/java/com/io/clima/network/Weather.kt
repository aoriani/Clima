package com.io.clima.network

import android.os.Parcelable
import com.io.clima.network.internal.Forecast
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val id: Long,
    val name: String,
    val condition: Condition,
    val temperature: Double,
    val feelsLikeTemperature: Double,
    val minTemperature: Double,
    val maxTemperature: Double,
    val humidity: Int
) : Parcelable {
    enum class Condition {
        Thunderstorm,
        Drizzle,
        Rain,
        Snow,
        Mist,
        Smoke,
        Haze,
        Fog,
        Tornado,
        Sunny,
        Cloudy,
        Other
    }
}

private fun Int.toCondition(): Weather.Condition = when (this) {
    in 200..232 -> Weather.Condition.Thunderstorm
    in 300..321 -> Weather.Condition.Drizzle
    in 500..531 -> Weather.Condition.Rain
    in 600..623 -> Weather.Condition.Snow
    701 -> Weather.Condition.Mist
    711 -> Weather.Condition.Smoke
    721 -> Weather.Condition.Haze
    741 -> Weather.Condition.Fog
    781 -> Weather.Condition.Tornado
    800 -> Weather.Condition.Sunny
    in 801..804 -> Weather.Condition.Cloudy
    else -> Weather.Condition.Other
}

private fun kelvinToFahrenheit(kelvin: Double): Double {
    return (kelvin - 273.15) * 9.0/5.0 + 32.0
}

internal fun Forecast.toWeather(): Weather {
    return Weather(
        id = this.id,
        name = this.name,
        condition = this.weather.firstOrNull()?.id?.toCondition() ?: Weather.Condition.Other,
        temperature = kelvinToFahrenheit(this.main.temp),
        feelsLikeTemperature = kelvinToFahrenheit(this.main.feelsLike),
        minTemperature = kelvinToFahrenheit(this.main.tempMin),
        maxTemperature = kelvinToFahrenheit(this.main.tempMax),
        humidity = this.main.humidity
    )
}