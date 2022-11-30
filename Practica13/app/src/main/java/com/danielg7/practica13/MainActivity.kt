package com.danielg7.practica13

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var id_foto = intArrayOf(
        R.drawable.luna,
        R.drawable.fases_lunar,
        R.drawable.luna_nueva,
        R.drawable.creciente_concava,
        R.drawable.cuarto_creciente,
        R.drawable.creciente_convexa,
        R.drawable.luna_llena,
        R.drawable.gibosa_menguante,
        R.drawable.cuarto_menguante,
        R.drawable.lunula_menguante
    )
    var nombrefoto = arrayOf(
        "Luna",
        "Fases de la luna",
        "Luna Nueva",
        "Creciente Concava",
        "Cuarto Creciente",
        "Creciente Convexa",
        "Luna Llena",
        "Gibosa Menguante",
        "Cuarto Menguante",
        "Lunula Menguante"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tvName : TextView = findViewById(R.id.tvName)
        val btnBack : Button = findViewById(R.id.btnBack)
        val btnNext : Button = findViewById(R.id.btnNext)
        val ivFondo : ImageView = findViewById(R.id.ivFondo)

        var i = 0
        var total_fotos = 0

        ivFondo.setImageResource(id_foto[0])
        tvName.text = nombrefoto[0]
        total_fotos = id_foto.size
        btnBack.setOnClickListener {
            i--
            if (i < 0) {
                i = total_fotos - 1
            }
            ivFondo.setImageResource(id_foto[i])
            tvName.text = nombrefoto[i]
        }
        btnNext.setOnClickListener {
            i++
            if (i > total_fotos - 1) {
                i = 0
            }
            ivFondo.setImageResource(id_foto[i])
            tvName.text = nombrefoto[i]
        }
    }
}