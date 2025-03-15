package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class third : AppCompatActivity() {
    lateinit var metr: TextView
    lateinit var result: TextView
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btn = findViewById(R.id.button)
        metr = findViewById(R.id.metr)
        result = findViewById(R.id.rez)

        // Получаем данные из Intent
        val metraj = intent.getIntExtra("metr", 0)
        val res = intent.getStringExtra("result") ?: "Нет данных"

        metr.text = metraj.toString()
        result.text = res
        btn.setOnClickListener {
            val intent = Intent(this@third,FlatBank::class.java)
            startActivity(intent)
        }
    }
}
