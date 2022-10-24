package com.danielg7.practica9

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvArchivo: TextView = findViewById(R.id.tvArchivo)

        val entradaDatos: InputStream = resources.openRawResource(R.raw.texto)
        val stream = InputStreamReader(entradaDatos)
        val buffer = BufferedReader(stream)

        var lineaDatos: String?
        while (true) {
            try {
                lineaDatos = buffer.readLine()
                if (lineaDatos == null) {
                    break
                }
                println(lineaDatos)
                tvArchivo.append("""
                    
                    $lineaDatos
                    
                """.trimIndent())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}