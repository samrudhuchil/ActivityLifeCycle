package com.samrudh.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AvengersActivity : AppCompatActivity() {
    var titleName = "Avenger"
    lateinit var etMessage: EditText
    lateinit var btnSend: Button
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scroll_view)
        println("onCreate called")
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        titleName = sharedPreferences.getString("Title", "Avenger").toString()
        title = titleName
        val intentMessage = Intent(this@AvengersActivity, MessageActivity::class.java)
        etMessage = findViewById(R.id.etMessage)
        btnSend = findViewById(R.id.btnSend)
        btnLogout= findViewById(R.id.btnLogout)

        btnSend.setOnClickListener {
            val etMessageCopied = etMessage.text.toString()
            intentMessage.putExtra("Message", etMessageCopied)
            println(etMessageCopied)
            startActivity(intentMessage)

        }
        btnLogout.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this@AvengersActivity, LoginActivity::class.java)
            finish()
            startActivity(intent)
        }


    }
}