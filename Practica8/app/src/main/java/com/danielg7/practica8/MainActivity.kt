package com.danielg7.practica8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPortada: Button = findViewById(R.id.btnPortada)
        val btnCalculadora: Button = findViewById(R.id.btnCalculadora)
        val btnConvertidor: Button = findViewById(R.id.btnConvertidor)

        btnPortada.setOnClickListener { Portada.startActivity(this) }
        btnCalculadora.setOnClickListener { Calculadora.startActivity(this) }
        btnConvertidor.setOnClickListener { Convertidor.startActivity(this) }
    }
}