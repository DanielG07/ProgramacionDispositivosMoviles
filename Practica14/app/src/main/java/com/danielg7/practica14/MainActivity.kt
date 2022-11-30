package com.danielg7.practica14

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var id_fotos = intArrayOf(
        R.drawable.foto1,
        R.drawable.foto2,
        R.drawable.foto3,
        R.drawable.foto4,
        R.drawable.foto5,
        R.drawable.foto6,
        R.drawable.foto7,
        R.drawable.foto8,
        R.drawable.foto9,
        R.drawable.foto10
    )
    var total_fotos = 0
    var i = 0
    var ancho_foto = 0
    var alto_foto = 0
    var ancho_canvas = 0
    var alto_canvas= 0
    var relacionFoto = 0f
    var relacionCanvas = 0f
    var nuevoX = 0
    var nuevoY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        total_fotos = id_fotos.size
        val album = VistaFotos(this)
        setContentView(album)
    }

    inner internal class VistaFotos(context: Context?) : View(context) {
        var foto: Drawable? = null
        override fun onDraw(canvas: Canvas) {
            val pintura = Paint()
            pintura.setColor(Color.rgb(200, 100, 188))
            canvas.drawPaint(pintura)
            foto = this.getResources().getDrawable(id_fotos.get(i))
            ancho_foto = foto!!.intrinsicWidth
            alto_foto = foto!!.intrinsicHeight
            ancho_canvas = getWidth()
            alto_canvas = getHeight()
            relacionCanvas = alto_canvas.toFloat() / ancho_canvas
            relacionFoto = alto_foto.toFloat() / ancho_foto
            if (relacionCanvas > relacionFoto) {
                nuevoX = ancho_canvas
                nuevoY = (relacionFoto * nuevoX).toInt()
            } else {
                nuevoY = alto_canvas
                nuevoX = (nuevoY / relacionFoto).toInt()
            }
            // Declara en donde iniciar la foto. Y da el ancho y alto de la foto
            foto!!.setBounds(0, 0, nuevoX, nuevoY)
            foto!!.draw(canvas)
        }

        override fun onTouchEvent(evento: MotionEvent): Boolean {
            val x = evento.x
            val y = evento.y
            if (evento.action == MotionEvent.ACTION_DOWN) {
                if (x >= nuevoX / 2 && x <= nuevoX && y <= nuevoY) {
                    i++
                    if (i == total_fotos) {
                        i = 0
                    }
                } else if (x >= 0 && x <= nuevoX / 2 && y <= nuevoY) {
                    i--
                    if (i == -1) {
                        i = total_fotos - 1
                    }
                }
            }
            invalidate()
            return true
        }
    }

}