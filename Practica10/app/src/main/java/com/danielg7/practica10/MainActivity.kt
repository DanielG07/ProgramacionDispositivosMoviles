package com.danielg7.practica10

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        var width = displayMetrics.widthPixels
        var height = displayMetrics.heightPixels

        val miGrafico = Vistagrafica(this, width, height)
        setContentView(miGrafico)


    }

    class Vistagrafica(
        context: Context,
        width: Int,
        height: Int
    ): View(context) {
        var xC = 300F
        var yC = 300F

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            val paint = Paint()

            canvas?.drawColor(Color.GREEN)

            paint.color = Color.WHITE
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 50F
            canvas?.drawRect(0F, 0F, width.toFloat(), height.toFloat(), paint)
            paint.strokeWidth = 25F
            canvas?.drawRect(width.toFloat() / 4 , 0F, width.toFloat() * 3 / 4, height.toFloat() / 10, paint)
            canvas?.drawRect(width.toFloat() / 4 , height.toFloat() - height.toFloat() / 10, width.toFloat() * 3 / 4, height.toFloat(), paint)
            canvas?.drawCircle(width.toFloat() * 5 / 10, height.toFloat() / 2, width.toFloat() * 1 / 10, paint)
            paint.style = Paint.Style.FILL
            canvas?.drawLine(0F, height.toFloat()/2, width.toFloat() * 2 / 5, height.toFloat()/2, paint)
            canvas?.drawLine(width.toFloat() * 3 / 5, height.toFloat()/2, width.toFloat(), height.toFloat() / 2, paint)

            paint.color = Color.BLACK
            paint.strokeWidth = 1F
            paint.textSize = 60F
            paint.style = Paint.Style.FILL_AND_STROKE
            paint.textAlign = Paint.Align.CENTER
            canvas?.drawText("FCB", width.toFloat() / 2, height.toFloat() / 15, paint)
            canvas?.drawText("RMCF", width.toFloat() / 2, height.toFloat() - height.toFloat() / 20, paint)

            val trazo = Path() //Revisar que sea Path para graficos

            trazo.addCircle(width.toFloat() * 5 / 10, height.toFloat() / 2, width.toFloat() * 1 / 10, Path.Direction.CCW)

            canvas?.drawTextOnPath("UEFA", trazo, 170F, 80F, paint)
            canvas?.drawTextOnPath("UEFA", trazo, -170F, 80F, paint)


        }
    }
}