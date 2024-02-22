package com.io.clima.network.internal

import com.google.gson.annotations.SerializedName

data class Forecasts(
    val cnt: Long,
    val list: List<Forecast>
)

data class Forecast(
    val coord: Coord,
    val weather: List<Weather> = emptyList(),
    val base: String? = null,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds,
    val dt: Long,
    val sys: Sys,
    val timezone: Long? = null,
    val id: Long,
    val name: String,
    val cod: Long? = null
) {

    data class Clouds(
        val all: Long
    )

    data class Coord(
        val lon: Double,
        val lat: Double
    )

    data class Main(
        val temp: Double,

        @SerializedName("feels_like")
        val feelsLike: Double,

        @SerializedName("temp_min")
        val tempMin: Double,

        @SerializedName("temp_max")
        val tempMax: Double,

        val pressure: Long,
        val humidity: Int
    )

    data class Sys(
        val type: Long? = null,
        val id: Long? = null,
        val country: String,
        val sunrise: Long,
        val sunset: Long
    )

    data class Weather(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String
    )

    data class Wind(
        val speed: Double,
        val deg: Long
    )
}
