package com.example.jokes.repository

import com.example.jokes.api.ApiService
import javax.inject.Inject

class JokesRepository
@Inject
constructor(private val apiService: ApiService){
    suspend fun getRandomJokes() = apiService.getRandomJokes()
}