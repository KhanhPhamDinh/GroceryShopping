package com.example.groceryshopping.ui.main.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


//enum class TopMoviesAPIStatus { LOADING, ERROR, DONE }

//class HomeViewModel:  ViewModel()  {
//
//    // The internal MutableLiveData that stores the status of the most recent request
//    private val _status = MutableLiveData<TopMoviesAPIStatus>()
//
//    // The external immutable LiveData for the request status
//    val status: LiveData<TopMoviesAPIStatus>
//        get() = _status
//
//    // Internally, we use a MutableLiveData, because we will be updating the List of MarsProperty
//    // with new values
//    private val _topMovies = MutableLiveData<List<TopMovies>>()
//
//    // The external LiveData interface to the property is immutable, so only this class can modify
//    val topMovies: LiveData<List<TopMovies>>
//        get() = _topMovies
//
//    init {
//        getTopMovie("k_4j6l0tcu")
//    }
//
//    private fun getTopMovie(APIKey: String){
////        viewModelScope.launch {
////            _status.value = TopMoviesAPIStatus.LOADING
////            try {
////                _topMovies.value = TopMovieApi.retrofitService.getTopMovies(APIKey).enqueue(this)
////                _status.value = TopMoviesAPIStatus.DONE
////            } catch (e: Exception) {
////                _status.value = TopMoviesAPIStatus.ERROR
////                _topMovies.value = ArrayList()
////            }
////        }
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        Log.i("SignUpViewModel", "SignUpViewModel destroyed!")
//    }
//
//}