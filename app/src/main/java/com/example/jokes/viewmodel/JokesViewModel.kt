package com.example.jokes.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokes.models.JokesItem
import com.example.jokes.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModel
    @Inject
    constructor(private val repository: JokesRepository) : ViewModel(){

        private val _response = MutableLiveData<List<JokesItem>>()
        val responseJoke :  LiveData<List<JokesItem>>
        get()  = _response

    init {
        getAllRandomJokes()
    }

    private fun getAllRandomJokes() = viewModelScope.launch {
        repository.getRandomJokes().let { response ->
        if (response.isSuccessful){
            _response.postValue(response.body())
        }else
            Log.d("TAG","getAllJokes Error : ${response.code()}")

        }
    }
    }