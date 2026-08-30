package com.example.guia6_discusionresultados

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Vincular los elementos de la interfaz con las variables de Kotlin
        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val rgGenero = findViewById<RadioGroup>(R.id.rgGenero)
        val cbTerminos = findViewById<CheckBox>(R.id.cbTerminos)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        // 2. Configurar la acción al presionar el botón de registro
        btnRegistrar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val apellido = etApellido.text.toString().trim()
            val correo = etCorreo.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val generoSeleccionadoId = rgGenero.checkedRadioButtonId
            val aceptaTerminos = cbTerminos.isChecked

            // 3. Validaciones paso a paso
            when {
                nombre.isEmpty() -> {
                    etNombre.error = "Por favor, ingresa tu nombre"
                    etNombre.requestFocus()
                }
                apellido.isEmpty() -> {
                    etApellido.error = "Por favor, ingresa tu apellido"
                    etApellido.requestFocus()
                }
                correo.isEmpty() -> {
                    etCorreo.error = "Por favor, ingresa tu correo electrónico"
                    etCorreo.requestFocus()
                }
                password.isEmpty() -> {
                    etPassword.error = "Por favor, ingresa una contraseña"
                    etPassword.requestFocus()
                }
                generoSeleccionadoId == -1 -> {
                    Toast.makeText(this, "Selecciona una opción de género", Toast.LENGTH_SHORT).show()
                }
                !aceptaTerminos -> {
                    Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    // Si todo es correcto, mostramos un mensaje de éxito
                    Toast.makeText(this, "¡Registro completado con éxito!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}