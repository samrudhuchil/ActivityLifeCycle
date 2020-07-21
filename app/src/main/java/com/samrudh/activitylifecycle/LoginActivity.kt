package com.samrudh.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var etAvengerMobileNumber: EditText
    lateinit var etAvengerPassword: EditText
    lateinit var btnAvengerLogin: Button
    lateinit var txtAvengerForgotPassword: TextView
    lateinit var txtAvengerRegister: TextView
    val validMobileNumber = arrayOf("7021406017", "7977280437")
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos", "ritik")
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"

        etAvengerMobileNumber = findViewById(R.id.etAvengerMobileNumber)
        etAvengerPassword = findViewById(R.id.etAvengerPassword)
        btnAvengerLogin = findViewById(R.id.btnAvengerLogin)
        txtAvengerForgotPassword = findViewById(R.id.txtAvengerForgotPassword)
        txtAvengerRegister = findViewById(R.id.txtAvengerRegister)


        btnAvengerLogin.setOnClickListener {
            val mobileNumber = etAvengerMobileNumber.text.toString()
            val password = etAvengerPassword.text.toString()
            var nameOfAvenger: String = "Avenger"
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            if (validMobileNumber.contains(mobileNumber)) {
                when (password) {
                    validPassword[0] -> {
                        nameOfAvenger = "Tony Stark"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_LONG)
                            .show()
                    }
                    validPassword[1] -> {
                        nameOfAvenger = "Steve Rogers"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_LONG)
                            .show()
                    }
                    validPassword[2] -> {
                        nameOfAvenger = "Bruce Banner"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_LONG)
                            .show()
                    }
                    validPassword[3] -> {
                        nameOfAvenger = "The Avenger"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_LONG)
                            .show()
                    }
                    validPassword[4] -> {
                        nameOfAvenger = "Ritik Sharma"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                        Toast.makeText(this@LoginActivity, "Login Successful", Toast.LENGTH_LONG)
                            .show()
                    }
                    else -> {
                        Toast.makeText(
                            this@LoginActivity,
                            "Incorrect Credentials !",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            } else {
                Toast.makeText(this@LoginActivity, "Incorrect Credentials !", Toast.LENGTH_LONG)
                    .show()
            }
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }

    fun forgotPasswordClick(view: View) {
        Toast.makeText(
            this@LoginActivity,
            "forgot password was clicked..",
            Toast.LENGTH_LONG
        ).show()
    }

    fun registerYourselfClick(view: View) {
        Toast.makeText(
            this@LoginActivity,
            "Register Yourself was clicked..",
            Toast.LENGTH_LONG
        ).show()
    }


}
