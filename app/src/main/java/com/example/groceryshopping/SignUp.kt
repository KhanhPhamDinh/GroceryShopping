package com.example.groceryshopping

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.groceryshopping.viewmodels.SignUpViewModel
import com.example.groceryshopping.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    private lateinit var _binding: ActivitySignUpBinding
    private lateinit var _signUpViewModel: SignUpViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        Log.i("SignUp", "Called ViewModelProvider.get")
        _signUpViewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)

        _binding.buttonSignUp.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        _binding.textViewLogin.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()

    }

    override fun onStop() {
        super.onStop()
    }

    fun signUp(){

    }

}