package com.example.star_wars_character_explorer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.star_wars_character_explorer.service.model.People
import com.example.star_wars_character_explorer.service.repository.StarWarsRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CharacterViewModel constructor(private val starWarsRepository: StarWarsRepository) : ViewModel() {

//    suspend fun getCharecterList(): MutableLiveData<List<People>> {
//        return starWarsRepository.getCharecterResult()
//    }

    val errorMessage = MutableLiveData<String>()
    val charaterList = MutableLiveData<List<People>>()
    private var job: Job? = null
    private val loading = MutableLiveData<Boolean>()

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }


    fun getAllMovies() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = starWarsRepository.getAllMovies()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    charaterList.postValue(response.body()!!.results)
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }

    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }




}