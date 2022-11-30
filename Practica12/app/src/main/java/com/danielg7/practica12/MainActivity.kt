package com.danielg7.practica12

import android.R.attr
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val miGrafico = Vistagrafica(this)
        setContentView(miGrafico)
    }

    class Vistagrafica(context: Context) : View(context) {
        var xC = 300F
        var yC = 300F

        var x = floatArrayOf(250F, 800F, 250F, 800F)
        var y = floatArrayOf(500f, 500F, 1600F, 1600F)
        var radio = floatArrayOf(60f, 100f, 125f, 155f)
        var seleccion = -1

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)

            val radio = 50F
            val paint = Paint()

            canvas?.drawColor(Color.YELLOW)
            paint.setColor(Color.BLUE)
            for(i in 0..3){
                canvas?.drawCircle(x[i], y[i], radio*(i+1), paint)
            }

            paint.setColor(Color.BLACK)
            paint.textSize = 60F
            paint.style = Paint.Style.FILL_AND_STROKE

            for(i in 0..3){
                canvas?.drawText("x = ${x[i]}, y = ${y[i]}", 100F, (50F*(i+2)), paint)
            }

            canvas?.drawText("Selección: $seleccion", 100F, 300F, paint)
        }

        override fun onTouchEvent(event: MotionEvent?): Boolean {
            xC = event?.x ?: xC
            yC = event?.y ?: yC
            invalidate()
            var distancia: Float
            if (event != null) {
                if (event.getAction() === MotionEvent.ACTION_DOWN) {
                    seleccion = -1
                    for (i in 0..3) {
                        distancia = Math.sqrt(((xC - x[i]) * (xC - x[i]) + (yC - y[i]) * (yC - y[i])).toDouble()).toFloat()
                        if (distancia < radio[i]) {
                            seleccion = i
                            invalidate()
                        }
                    }
                }
            }
            if (seleccion !== -1) {
                x[seleccion] = xC
                y[seleccion] = yC
                invalidate()
            }

            return true

        }
    }
}