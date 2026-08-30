package com.example.guia6_discusionresultados

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        // Vincular el botón de la vista principal (asegúrate de tener un botón con este ID en activity_main.xml)
        val btnIrRegistro = findViewById<Button>(R.id.btnIrRegistro)

        // Configurar la navegación hacia activity_registro
        btnIrRegistro.setOnClickListener {
            val intent = Intent(this, activity_registro::class.java)
            startActivity(intent)
        }
    }
}