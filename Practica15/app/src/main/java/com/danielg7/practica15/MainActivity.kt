package com.danielg7.practica15

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var animacion : AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar: Button = findViewById<View>(R.id.btnIniciar) as Button
        val btnDetener: Button = findViewById<View>(R.id.btnDetenr) as Button
        val foto: ImageView = findViewById<View>(R.id.ivFondo) as ImageView
        foto.setBackgroundResource(R.drawable.animacion_fotos)
        foto.setAdjustViewBounds(false)
        foto.setVisibility(View.VISIBLE)

        btnIniciar.setOnClickListener(this)
        btnDetener.setOnClickListener(this)
        animacion = AnimationDrawable()
        animacion = foto.getBackground() as AnimationDrawable
        foto.setImageDrawable(animacion)

    }

    override fun onClick(p0: View?) {
        animacion.stop();
        if (p0 != null) {
            if (p0.getId() == R.id.btnIniciar){
                animacion.start();
            }
            else{
                animacion.stop();
            }
        }

    }
}