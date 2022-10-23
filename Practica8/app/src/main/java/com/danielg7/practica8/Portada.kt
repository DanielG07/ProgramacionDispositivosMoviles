package com.danielg7.practica8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Portada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portada)
    }

    companion object {
        fun startActivity(context: Context) {
            Toast.makeText(context, "Navegando a Portada", Toast.LENGTH_SHORT).show()

            val intent = Intent(context, Portada::class.java)
            context.startActivity(intent)
        }
    }
}