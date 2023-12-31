package com.example.star_wars_character_explorer.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.star_wars_character_explorer.service.model.People
import com.example.star_wars_character_explorer.service.repository.CharacterRepository
import com.example.star_wars_character_explorer.service.repository.StarShipRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val characterRepository: CharacterRepository) : ViewModel(){


    val errorMessage = MutableLiveData<String>()
    private val _response = MutableLiveData<People>()
    val responseCharacter : LiveData<People> get() = _response

    private var job: Job? = null
    val loading = MutableLiveData<Boolean>()


    val list =  characterRepository.getCharacters().cachedIn(viewModelScope)


    fun getCharacter(position : Int) : LiveData<People>  {
        getSingleCharacter(position)
      return responseCharacter
    }


    private fun getSingleCharacter(position : Int) = viewModelScope.launch {
        characterRepository.getSingleCharacter(position).let { response ->
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