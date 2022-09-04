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


        val tvAlumnoT = TextViewBodyFactory(
            this,
            params,
            "Alumno",
            24F,
            "#13322b"
        )
        val tvAlumno = TextViewBodyFactory(
            this,
            paramsTexto,
            "Daniel González Jiménez",
            24F,
            "#5F5F5F"
        )

        val tvUnidadT = TextViewBodyFactory(
            this,
            params,
            "Unidad de Aprendizaje:",
            24F,
            "#13322b"
        )
        val tvUnidad = TextViewBodyFactory(
            this,
            paramsTexto,
            "Programación de Dispositivos Móviles",
            24F,
            "#5F5F5F"
        )


        val tvGrupoT = TextViewBodyFactory(
            this,
            params,
            "Grupo:",
            24F,
            "#13322b"
        )

        val tvGrupo = TextViewBodyFactory(
            this,
            paramsTexto,
            "2TM13",
            24F,
            "#5F5F5F"
        )

        val tvProfesorT = TextViewBodyFactory(
            this,
            params,
            "Profesor:",
            24F,
            "#13322b"
        )

        val tvProfesor = TextViewBodyFactory(
            this,
            paramsTexto,
            "José Alfredo Bermudez Sosa",
            24F,
            "#5F5F5F"
        )

        val tvBoletaT = TextViewBodyFactory(
            this,
            params,
            "Boleta:",
            24F,
            "#13322b"
        )

        val tvBoleta = TextViewBodyFactory(
            this,
            paramsTexto,
            "2019640295",
            24F,
            "#5F5F5F"
        )

        val llBottom = LinearLayout(this)
        llBottom.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        llBottom.orientation = LinearLayout.VERTICAL
        llBottom.setPadding(this.dpToPx(8))
        llBottom.setBackgroundColor(Color.parseColor("#333333"))

        val tvIPN = TextViewBodyFactory(
            this,
            paramsTexto,
            "INSTITUTO POLITÉCNICO NACIONAL",
            14F,
            "#FFFFFF"
        )

        val tvDireccion = TextViewBodyFactory(
            this,
            paramsTexto,
            "Avenida Instituto Politécnico Nacional No. 2580, Col Barrio la Laguna Ticomán, Gustavo A. Madero, Ciudad de México, C.P. 07340. Teléfono: 57296000, extensión 56806",
            14F,
            "#FFFFFF"
        )

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

fun TextViewBodyFactory(
    context: Context,
    params: LinearLayout.LayoutParams,
    text: String,
    textSize: Float,
    textColor: String
): TextView {
    val tv = TextView(context)
    tv.layoutParams = params
    tv.text = text
    tv.textSize = textSize
    tv.setTextColor(Color.parseColor(textColor))
    tv.textAlignment = View.TEXT_ALIGNMENT_CENTER

    return tv
}

fun Context.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}