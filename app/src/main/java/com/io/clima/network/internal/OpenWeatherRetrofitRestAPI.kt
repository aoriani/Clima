package com.io.clima.network.internal

import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherRetrofitRestAPI {

    @GET("group")
    suspend fun fetchWeatherForCities(
        @Query("id") cityIds: List<Long>,
        @Query("appid") apiKey: String
    ): Forecasts

    @GET("weather")
    suspend fun fetchWeatherForCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Forecast
}