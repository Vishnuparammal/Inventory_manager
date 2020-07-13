package com.example.sra
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.sra.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
class LoginActivity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance()
        binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        // user login
        binding.buttonSignIn.setOnClickListener(){
            val email = binding.editTextEmailAddress.text.toString()
            val password = binding.editTextTextPassword.text.toString()
            firebaseSignIn(email, password)
        }

        // guest user login
        binding.guestSignIn.setOnClickListener(){
            val guest_email = "guest@sra.com"
            val guest_password = "password"
            firebaseSignIn(guest_email, guest_password)
        }
    }

    private fun firebaseSignIn(email: String, password: String){
        if(email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "enter credentials", Toast.LENGTH_LONG).show()
        }
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
            if( ! it.isSuccessful){
                Toast.makeText(this, "login failed ", Toast.LENGTH_LONG).show()
                return@addOnCompleteListener
            }
            Toast.makeText(this, "welcome $email", Toast.LENGTH_LONG).show()
            // navigate to main activity
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }
}