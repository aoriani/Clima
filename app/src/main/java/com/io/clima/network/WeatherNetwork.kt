package com.io.clima.network

import android.util.Log
import com.io.clima.network.internal.OpenWeatherRetrofitRestAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherNetwork {
    private val apiKey = "e8436a6e7b06d6872f8e593fac92e267"
    private val baseUrl = "https://api.openweathermap.org/data/2.5/"

    private val service = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().addNetworkInterceptor(HttpLoggingInterceptor { msg ->
            Log.i("Network", msg)
        }.setLevel(HttpLoggingInterceptor.Level.BODY)).build())
        .build()
        .create(OpenWeatherRetrofitRestAPI::class.java)

    suspend fun fetchWeatherForCities(): List<Weather> {
        return service.fetchWeatherForCities(
            listOf(5391749, 4684904, 3453643, 4219762, 2643743, 2988507, 1277333, 2692969), apiKey
        ).list.map { it.toWeather() }
    }

    suspend fun fetchWeatherForCity(city: String): Weather {
        return service.fetchWeatherForCity(city, apiKey).toWeather()
    }
}