package com.example.groceryshopping

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.IntentCompat
import com.example.groceryshopping.databinding.ActivityLoginBinding
import com.example.groceryshopping.databinding.ActivitySignUpBinding

class Login : AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        _binding.buttonLogin.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        _binding.textViewSignUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }

    }
}