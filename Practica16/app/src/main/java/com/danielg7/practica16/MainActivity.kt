package com.danielg7.practica16

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener{

    lateinit var foto: ImageView
    lateinit var animacion: AnimationDrawable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foto = findViewById(R.id.ivFondo)
        val boton1: Button = findViewById(R.id.btnIniciar)
        val boton2: Button = findViewById(R.id.btnDetenr)

        val t = 750
        animacion = AnimationDrawable()

        animacion.addFrame(resources.getDrawable(R.drawable.foto1), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto2), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto3), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto4), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto5), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto6), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto7), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto8), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto9), t)
        animacion.addFrame(resources.getDrawable(R.drawable.foto10), t)

        animacion.setOneShot(false)
        foto.setImageDrawable(animacion)
        boton1.setOnClickListener(this)
        boton2.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        animacion.stop();
        if (p0 != null) {
            if(p0.getId() == R.id.btnIniciar){
                animacion.start();
            }
            else{
                animacion.stop();
            }
        }

    }
}