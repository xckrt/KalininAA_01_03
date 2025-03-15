package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Delay

const val metr = 50.0
class raschet : AppCompatActivity() {
    lateinit var spin:Spinner
    lateinit var edit:EditText
    lateinit var chosen:TextView
    lateinit var gen:Button
    lateinit var result:TextView
    lateinit var back:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_raschet)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            spin = findViewById(R.id.spinner)
            edit = findViewById(R.id.metr)
            chosen = findViewById(R.id.textspin)
            gen = findViewById(R.id.button)
            result = findViewById(R.id.rez)
            back = findViewById(R.id.back)

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun back(view: View) {
        val intent = Intent(this@raschet,FlatBank::class.java)
        startActivity(intent)
    }

    fun raschit(view: View) {
        when (spin.selectedItem.toString())
        {
            "1-о комнатная квартира" -> {
                if(edit.text.toString().isDigitsOnly())
                {
                    chosen.text = spin.selectedItem.toString()
                    result.text = (metr * edit.text.toString().toInt()*1.4).toString()
                }
                else
                {
                    edit.error = "Должны быть числа!"
                }

            }
            "2-х комнатная квартира" -> {
                if(edit.text.toString().isDigitsOnly())
                {
                    chosen.text = spin.selectedItem.toString()
                    result.text = (metr * edit.text.toString().toInt()).toString() + " т.р."
                }
                else
                {
                    edit.error = "Должны быть числа!"
                }
            }
            "3-х комнатная квартира" -> {
                if(edit.text.toString().isDigitsOnly())
                {
                    chosen.text = spin.selectedItem.toString()
                    result.text = (metr * edit.text.toString().toInt()*0.8).toString() + " т.р."
                }
                else
                {
                    edit.error = "Должны быть числа!"
                }
            }
            "Студия" -> {
                if(edit.text.toString().isDigitsOnly())
                {
                    chosen.text = spin.selectedItem.toString()
                    result.text = (metr * edit.text.toString().toInt()*1.1).toString() + " т.р."
                }
                else
                {
                    edit.error = "Должны быть числа!"
                }
            }
        }
        Thread.sleep(3000)

        val intent = Intent(this@raschet,third::class.java)
        intent.putExtra("metr",edit.text.toString().toInt())
        intent.putExtra("result",result.text.toString())
        startActivity(intent)
    }
}