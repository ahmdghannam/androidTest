package com.medo.kotlinmessenger_letsbuildthatapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

       btnRegister.setOnClickListener {
    performRegister()
  }
      login.setOnClickListener {
          Log.d("text","try to show login activity")
      startActivity(Intent(this,LoginActivity::class.java))

      }
        btnAddPhoto.setOnClickListener {
            Log.d("text", "try to show photo selector")
            val intent=Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent,0)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    if (requestCode==0&&resultCode== RESULT_OK&&data!=null)
    {

    }
    }

    private fun performRegister() {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        Log.d("text", "Email is :$email")
        Log.d("text", "Password is :$password")
        if (email.isEmpty() || password.isEmpty()) return
        //firebase authentication
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful)
                    return@addOnCompleteListener
                // successful
                Log.d("Main", "Successfully created user ,uid:${it.result?.user?.uid}")

            }.addOnFailureListener {
                Log.d("Main", "filed to create user"+it.message)
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }

    }
}
