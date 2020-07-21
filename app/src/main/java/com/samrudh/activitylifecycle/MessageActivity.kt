package com.samrudh.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {
    var message: String = "No Conversation"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
        title="Your Messages"
        val text: TextView = findViewById(R.id.txtViewMessage)
        if (intent!=null) {
            message = intent.getStringExtra("Message")
        }
        text.text=message

    }
}
