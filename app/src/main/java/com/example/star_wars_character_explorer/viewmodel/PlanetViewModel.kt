package com.example.star_wars_character_explorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.star_wars_character_explorer.service.model.People
import com.example.star_wars_character_explorer.service.model.Planet
import com.example.star_wars_character_explorer.service.repository.PlanetRepository
import com.example.star_wars_character_explorer.service.repository.StarShipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetViewModel @Inject constructor(private val planetRepository: PlanetRepository) : ViewModel(){


    val errorMessage = MutableLiveData<String>()
    private val _response = MutableLiveData<Planet>()
    val responsePlanet : LiveData<Planet> get() = _response

    private var job: Job? = null
    val loading = MutableLiveData<Boolean>()


    val list =  planetRepository.getPlanet().cachedIn(viewModelScope)


    fun getPlanet(position : Int) : LiveData<Planet>  {
        getSinglePlanet(position)
        return responsePlanet
    }


    private fun getSinglePlanet(position : Int) = viewModelScope.launch {
        planetRepository.getSinglePlanet(position).let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body()!!)
                loading.value = false
            } else {
                onError("Error : ${response.message()} ")
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