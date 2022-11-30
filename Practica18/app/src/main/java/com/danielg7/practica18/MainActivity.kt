package com.danielg7.practica18


import android.os.Bundle
import android.view.animation.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animEscalamiento = AnimationSet(true)
        val animRotacion = AnimationSet(true)
        val animSecuencia = AnimationSet(true)
        val animTransparencia = AnimationSet(true)
        val animTraslacion = AnimationSet(true)

        val tvEscalamiento = findViewById<TextView>(R.id.tvEscalamiento)
        val tvRotacion = findViewById<TextView>(R.id.tvRotacion)
        val tvSecuencia = findViewById<TextView>(R.id.tvSecuencia)
        val tvTransparencia = findViewById<TextView>(R.id.tvTransparencia)
        val tvTraslacion = findViewById<TextView>(R.id.tvTraslacion)

        // Traslacion
        val rs1 = TranslateAnimation.RELATIVE_TO_SELF
        val anim1 = TranslateAnimation(rs1, 0F, rs1, 1F, rs1, 0F, rs1, 5F)
        anim1.setInterpolator(LinearInterpolator())
        anim1.setFillAfter(false)
        anim1.setDuration(2000)
        anim1.setRepeatMode(Animation.RESTART)
        anim1.setStartOffset(2000)

        // Rotacion
        val rs2 = TranslateAnimation.RELATIVE_TO_SELF
        val anim2 = RotateAnimation(0F, 360F, rs2, 0.5F, rs2, 0.5F)
        anim2.setFillAfter(false)
        anim2.setDuration(2000)
        anim2.setRepeatMode(Animation.RESTART)

        // Escalamiento
        val rs3 = ScaleAnimation.RELATIVE_TO_SELF
        val anim3 = ScaleAnimation(0F, 1F, 0F, 2F, rs3, 0.5F, rs3, 0.5F)
        anim3.setFillAfter(true)
        anim3.setDuration(2000)
        anim1.setStartOffset(5000)

        // Transparencia
        val anim4 = AlphaAnimation(1F, 0F)
        anim4.setFillAfter(true)
        anim4.setDuration(4000)
        anim4.setStartOffset(7000)

        animTraslacion.addAnimation(anim1)
        tvTraslacion.startAnimation(animTraslacion)

        animRotacion.addAnimation(anim2)
        tvRotacion.startAnimation(animRotacion)

        animEscalamiento.addAnimation(anim3)
        tvEscalamiento.startAnimation(animEscalamiento)

        animTransparencia.addAnimation(anim4)
        tvTransparencia.startAnimation(animTransparencia)

        animSecuencia.addAnimation(anim1)
        animSecuencia.addAnimation(anim2)
        animSecuencia.addAnimation(anim3)
        animSecuencia.addAnimation(anim4)
        tvSecuencia.startAnimation(animSecuencia)
    }

}