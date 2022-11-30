package com.danielg7.practica17


import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var tv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tvTraslacion)
        val animacion1: Animation = AnimationUtils.loadAnimation(this, R.anim.traslacion)
        animacion1.fillAfter = false
        animacion1.repeatMode = Animation.RESTART
        animacion1.repeatCount = 2
        tv.startAnimation(animacion1)

        tv = findViewById(R.id.tvRotacion)
        val animacion2: Animation = AnimationUtils.loadAnimation(this, R.anim.rotacion)
        animacion2.fillAfter = false
        animacion2.repeatMode = Animation.RESTART
        animacion2.repeatCount = 2
        tv.startAnimation(animacion2)

        tv = findViewById(R.id.tvTransparencia)
        val animacion3: Animation = AnimationUtils.loadAnimation(this, R.anim.transparencia)
        animacion3.fillAfter = false
        animacion3.repeatMode = Animation.RESTART
        animacion3.repeatCount = 2
        tv.startAnimation(animacion3)

        tv = findViewById(R.id.tvEscalamiento)
        val animacion4: Animation = AnimationUtils.loadAnimation(this, R.anim.escalamiento)
        animacion4.fillAfter = false
        animacion4.repeatMode = Animation.RESTART
        animacion4.repeatCount = 2
        tv.startAnimation(animacion4)


        tv = findViewById(R.id.tvSecuencia)
        val animacion5: Animation = AnimationUtils.loadAnimation(this, R.anim.secuencia)
        animacion5.fillAfter = false
        animacion5.repeatMode = Animation.RESTART
        animacion5.repeatCount = 2
        tv.startAnimation(animacion5)
    }

}