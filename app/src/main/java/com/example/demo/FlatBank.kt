package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FlatBank : AppCompatActivity() {
    lateinit var login:TextView
    lateinit var pass:TextView
    lateinit var but: Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flat_bank)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            login = findViewById(R.id.login)
            pass = findViewById(R.id.pass)
            but = findViewById(R.id.button)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun next(view: View) {
        if(!login.text.isNullOrEmpty() && !pass.text.isNullOrEmpty())
        {
            val intent = Intent(this@FlatBank,raschet::class.java)
            startActivity(intent)
        }
        else
        {
            login.error = "Заполните поле"
            pass.error = "Заполните поле"
        }
    }

}