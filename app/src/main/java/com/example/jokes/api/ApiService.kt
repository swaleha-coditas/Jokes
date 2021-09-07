package com.example.jokes.api

import com.example.jokes.helper.Constants
import com.example.jokes.models.JokesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.END_POINT)
    suspend fun getRandomJokes()  : Response<JokesResponse>
}