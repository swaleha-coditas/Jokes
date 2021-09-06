package com.example.jokes

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://official-joke-api.appspot.com/"
interface ApiInterface {
    @GET("random_ten")
    fun getRandomJokes(): Call<ArrayList<Jokes>>
}

object ApiService {
    val apiInstance : ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInstance = retrofit.create(ApiInterface::class.java)

    }
}