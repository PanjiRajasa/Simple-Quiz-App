package com.example.simplequizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplequizapp.ui.QuestionActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        variable declratation
        val startButton: Button = findViewById(R.id.button_start)
        val editTextName: EditText = findViewById(R.id.name_editText)

//        logic start here
        startButton.setOnClickListener {
            if ((editTextName).text.isNotEmpty()) {
                Intent(this@MainActivity, QuestionActivity::class.java).also {
                    startActivity(it)
                    finish()
                }
            } else {
                Toast.makeText(this@MainActivity, "Please enter your name", Toast.LENGTH_LONG).show()
            }
        }
    }
}