package com.pablosj.advanced2022.dogList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pablosj.advanced2022.Dog
import kotlinx.coroutines.launch

class DogListViewModel : ViewModel() {

    private val dogRepository = DogRepository()
    private val _dogList = MutableLiveData<List<Dog>>()
    val dogList: LiveData<List<Dog>>
        get() = _dogList

    init {
        downloadDog()
    }

    private fun downloadDog() {
        viewModelScope.launch {
            _dogList.value = dogRepository.downloadDogs()
        }
    }
}