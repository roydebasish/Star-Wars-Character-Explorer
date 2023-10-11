package com.example.star_wars_character_explorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.star_wars_character_explorer.service.model.StarShip
import com.example.star_wars_character_explorer.service.repository.StarShipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarShipViewModel @Inject constructor(private val starShipRepository: StarShipRepository) : ViewModel(){


    val errorMessage = MutableLiveData<String>()
    private val _response = MutableLiveData<StarShip>()
    val responseStarShip : LiveData<StarShip> get() = _response

    private var job: Job? = null
    val loading = MutableLiveData<Boolean>()


    val list =  starShipRepository.getStarShip().cachedIn(viewModelScope)


    fun getStarShip(position : Int) : LiveData<StarShip>  {
        getSingleStarShip(position)
        return responseStarShip
    }


    private fun getSingleStarShip(position : Int) = viewModelScope.launch {
        starShipRepository.getSingleStarShip(position).let { response ->
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