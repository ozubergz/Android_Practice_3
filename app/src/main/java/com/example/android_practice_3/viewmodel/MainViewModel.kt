package com.example.android_practice_3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_practice_3.model.Result
import com.example.android_practice_3.repo.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _result = MutableLiveData<Result>()

    val result : LiveData<Result>
        get() = _result

    fun getAnime(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val res = Repository.getAnime(title)
            _result.postValue(res.body())
        }
    }
}