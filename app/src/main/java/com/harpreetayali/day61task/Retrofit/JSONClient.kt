package com.harpreetayali.day61task.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object JSONClient
{
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://reqres.in/api/"
    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}