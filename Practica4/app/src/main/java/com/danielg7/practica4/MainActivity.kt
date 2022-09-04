package com.danielg7.practica4

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop
import androidx.core.view.setMargins
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val llMain: LinearLayout = findViewById(R.id.llMain)

        val llBody = LinearLayout(this)
        llBody.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            1F
        )
        llBody.orientation = LinearLayout.VERTICAL

        val llHeader = LinearLayout(this)
        llHeader.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        llHeader.orientation = LinearLayout.HORIZONTAL
        llHeader.gravity = Gravity.CENTER
        llHeader.setPadding(this.dpToPx(8))
        llHeader.setBackgroundColor(Color.parseColor("#6D1A42"))

        val ivIPN = ImageView(this)
        ivIPN.layoutParams = LinearLayout.LayoutParams(this.dpToPx(80), this.dpToPx(80))
        ivIPN.scaleType = ImageView.ScaleType.FIT_CENTER
        ivIPN.setImageDrawable(getDrawable(R.drawable.ipn_logo))

        val tvUPIITA = TextView(this)
        tvUPIITA.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            1F
        )
        tvUPIITA.text =
            "Unidad Profesional Interdisciplinaria en Ingenieria y Tecnologias Avanzadas"
        tvUPIITA.gravity = Gravity.CENTER
        tvUPIITA.textSize = 20F
        tvUPIITA.setTextColor(Color.parseColor("#FFFFFF"))

        val ivUPIITA = ImageView(this)
        ivUPIITA.layoutParams = LinearLayout.LayoutParams(this.dpToPx(80), this.dpToPx(80))
        ivUPIITA.scaleType = ImageView.ScaleType.FIT_CENTER
        ivUPIITA.setImageDrawable(getDrawable(R.drawable.upiita_logo))

        llHeader.addView(ivIPN)
        llHeader.addView(tvUPIITA)
        llHeader.addView(ivUPIITA)

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.setMargins(0, this.dpToPx(8), 0, 0)
        params.gravity = Gravity.CENTER

        val paramsTexto = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        paramsTexto.gravity = Gravity.CENTER

        val tvAlumnoT = TextView(this)
        tvAlumnoT.layoutParams = params
        tvAlumnoT.text =
            "Alumno:"
        tvAlumnoT.textSize = 24F
        tvAlumnoT.setTypeface(null, Typeface.BOLD)
        tvAlumnoT.setTextColor(Color.parseColor("#13322b"))
        tvAlumnoT.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvAlumno = TextView(this)
        tvAlumno.layoutParams = paramsTexto
        tvAlumno.text =
            "Daniel González Jiménez"
        tvAlumno.textSize = 24F
        tvAlumno.setTextColor(Color.parseColor("#5F5F5F"))
        tvAlumno.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvUnidadT = TextView(this)
        tvUnidadT.layoutParams = params
        tvUnidadT.text =
            "Unidad de Aprendizaje:"
        tvUnidadT.textSize = 24F
        tvUnidadT.setTypeface(null, Typeface.BOLD)
        tvUnidadT.setTextColor(Color.parseColor("#13322b"))
        tvUnidadT.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvUnidad = TextView(this)
        tvUnidad.layoutParams = paramsTexto
        tvUnidad.text =
            "Programación de Dispositivos Móviles"
        tvUnidad.textSize = 24F
        tvUnidad.setTextColor(Color.parseColor("#5F5F5F"))
        tvUnidad.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvGrupoT = TextView(this)
        tvGrupoT.layoutParams = params
        tvGrupoT.text =
            "Grupo:"
        tvGrupoT.textSize = 24F
        tvGrupoT.setTypeface(null, Typeface.BOLD)
        tvGrupoT.setTextColor(Color.parseColor("#13322b"))
        tvGrupoT.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvGrupo = TextView(this)
        tvGrupo.layoutParams = paramsTexto
        tvGrupo.text =
            "2TM13"
        tvGrupo.textSize = 24F
        tvGrupo.setTextColor(Color.parseColor("#5F5F5F"))
        tvGrupo.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvProfesorT = TextView(this)
        tvProfesorT.layoutParams = params
        tvProfesorT.text =
            "Profesor:"
        tvProfesorT.textSize = 24F
        tvProfesorT.setTypeface(null, Typeface.BOLD)
        tvProfesorT.setTextColor(Color.parseColor("#13322b"))
        tvProfesorT.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvProfesor = TextView(this)
        tvProfesor.layoutParams = paramsTexto
        tvProfesor.text =
            "José Alfredo Bermudez Sosa"
        tvProfesor.textSize = 24F
        tvProfesor.setTextColor(Color.parseColor("#5F5F5F"))
        tvProfesor.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvBoletaT = TextView(this)
        tvBoletaT.layoutParams = params
        tvBoletaT.text =
            "Boleta:"
        tvBoletaT.textSize = 24F
        tvBoletaT.setTypeface(null, Typeface.BOLD)
        tvBoletaT.setTextColor(Color.parseColor("#13322b"))
        tvBoletaT.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val tvBoleta = TextView(this)
        tvBoleta.layoutParams = paramsTexto
        tvBoleta.text =
            "2019640295"
        tvBoleta.textSize = 24F
        tvBoleta.setTextColor(Color.parseColor("#5F5F5F"))
        tvBoleta.textAlignment = View.TEXT_ALIGNMENT_CENTER

        val llBottom = LinearLayout(this)
        llBottom.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        llBottom.orientation = LinearLayout.VERTICAL
        llBottom.setPadding(this.dpToPx(8))
        llBottom.setBackgroundColor(Color.parseColor("#333333"))

        val tvIPN = TextView(this)
        tvIPN.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        tvIPN.text = "INSTITUTO POLITÉCNICO NACIONAL"
        tvIPN.textSize = 14F
        tvIPN.setTextColor(Color.parseColor("#FFFFFF"))
        tvIPN.gravity = Gravity.CENTER

        val tvDireccion = TextView(this)
        tvDireccion.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        tvDireccion.text =
            "Avenida Instituto Politécnico Nacional No. 2580, Col Barrio la Laguna Ticomán, Gustavo A. Madero, Ciudad de México, C.P. 07340. Teléfono: 57296000, extensión 56806"
        tvDireccion.textSize = 14F
        tvDireccion.setTextColor(Color.parseColor("#FFFFFF"))
        tvDireccion.gravity = Gravity.CENTER

        llBottom.addView(tvIPN)
        llBottom.addView(tvDireccion)

        llBody.addView(llHeader)
        llBody.addView(tvAlumnoT)
        llBody.addView(tvAlumno)
        llBody.addView(tvUnidadT)
        llBody.addView(tvUnidad)
        llBody.addView(tvGrupoT)
        llBody.addView(tvGrupo)
        llBody.addView(tvProfesorT)
        llBody.addView(tvProfesor)
        llBody.addView(tvBoletaT)
        llBody.addView(tvBoleta)
        llMain.addView(llBody)
        llMain.addView(llBottom)
    }
}

fun Context.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}