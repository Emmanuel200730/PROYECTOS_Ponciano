package com.example.music_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etCorreo : EditText
    private lateinit var  etPass : EditText
    private lateinit var  btnInicio : Button
    private lateinit var  etHelper : DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etCorreo = findViewById(R.id.etCorreo)
        etPass = findViewById(R.id.etPassword)
        btnInicio = findViewById(R.id.btnIngresar)

        dbHelper = DatabaseHelper(this)

        //EVENTO PARA INICIAR SESION
        btnInicio.setOnClickListener {
            //TODO: AGREGAR METODO DE INICIO DE SESION
        }

        val tvCrearCuenta = findViewById<TextView>(R.id.CrearCuenta)
            val intent = Intent(this, RegisterActivity :: class.java)
            startActivity(intent)
        }
    }
}