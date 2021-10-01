package com.medo.kotlinmessenger_letsbuildthatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener {
        val email=etEmail_login.text.toString()
            val password=etPassword_login.text.toString()
            Log.d("Login", "Attempt login with email/pw:$email/***")
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{}.addOnFailureListener{}
        }
           tvBack.setOnClickListener {
               finish()
           }
    }
}