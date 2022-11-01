package com.danielg7.practica11

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linearLayout: LinearLayout = findViewById(R.id.main)

        val rectangulo = Rect()
        linearLayout.getWindowVisibleDisplayFrame(rectangulo)
        val width = rectangulo.width()
        val height = rectangulo.height()

        var color = Color.BLUE
        var text = "Instituto Politecnico Nacional"
        val textSize = 60F
        var vista = Vistagrafica(
            context = this,
            positionX = width / 2,
            positionY = height / 20,
            color = color,
            textSize = textSize,
            text = text
        )
        var parametros = LinearLayout.LayoutParams(width, height / 15)
        vista.setLayoutParams(parametros)
        linearLayout.addView(vista)

        color = Color.RED
        text = "UPIITA"
        vista = Vistagrafica(
            context = this,
            positionX = width / 2,
            positionY = height / 20,
            color = color,
            textSize = textSize,
            text = text
        )
        vista.setLayoutParams(parametros)
        linearLayout.addView(vista)

        color = Color.BLUE
        text = "Daniel Gonzalez Jimenez"
        vista = Vistagrafica(
            context = this,
            positionX = width / 2,
            positionY = height / 20,
            color = color,
            textSize = textSize,
            text = text
        )
        vista.setLayoutParams(parametros)
        linearLayout.addView(vista)

        color = Color.RED
        text = "Programación de dispositivos moviles"
        vista = Vistagrafica(
            context = this,
            positionX = width / 2,
            positionY = height / 20,
            color = color,
            textSize = textSize,
            text = text
        )
        vista.setLayoutParams(parametros)
        linearLayout.addView(vista)

        color = Color.BLUE
        text = "30 Octubre 2022"
        vista = Vistagrafica(
            context = this,
            positionX = width / 2,
            positionY = height / 20,
            color = color,
            textSize = textSize,
            text = text
        )
        vista.setLayoutParams(parametros)
        linearLayout.addView(vista)

    }

    class Vistagrafica(
        context: Context,
        val positionX: Int,
        val positionY: Int,
        val color: Int,
        val textSize: Float,
        val text: String
    ) : View(context) {

        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            val paint = Paint()
            paint.color = color
            paint.textSize = textSize
            paint.textAlign = Paint.Align.CENTER
            canvas?.drawText(text, positionX.toFloat(), positionY.toFloat(), paint)

        }
    }
}