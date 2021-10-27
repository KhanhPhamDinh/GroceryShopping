package com.example.groceryshopping.ui.main.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class SignUpViewModel: ViewModel() {

    // Tracks the name
    lateinit var  name:String

    // Tracks the email
    lateinit var  email: String

    // Tracks the password
    lateinit var password: String

    // Tracks the confirmPassword
    lateinit  var confirmPassword: String

    init {
        Log.i("SignUpViewModel", "SignUpViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("SignUpViewModel", "SignUpViewModel destroyed!")
    }
}