package com.danielg7.practica7

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var tvInNombre: TextView
    lateinit var tvInApellido: TextView
    lateinit var tvInCelular: TextView
    lateinit var tvInEdad: TextView
    lateinit var tvInEmail: TextView

    lateinit var tvOutNombre: TextView
    lateinit var tvOutApellido: TextView
    lateinit var tvOutCelular: TextView
    lateinit var tvOutEdad: TextView
    lateinit var tvOutEmail: TextView

    lateinit var edtNombre: EditText
    lateinit var edtApellido: EditText
    lateinit var edtCelular: EditText
    lateinit var edtEdad: EditText
    lateinit var edtEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()

        tvInNombre = findViewById(R.id.tvInNombre)
        tvInApellido = findViewById(R.id.tvInApellido)
        tvInCelular = findViewById(R.id.tvInCelular)
        tvInEdad = findViewById(R.id.tvInEdad)
        tvInEmail = findViewById(R.id.tvInEmail)

        edtNombre = findViewById(R.id.edtNombre)
        edtApellido = findViewById(R.id.edtApellido)
        edtCelular = findViewById(R.id.edtCelular)
        edtEdad = findViewById(R.id.edtEdad)
        edtEmail = findViewById(R.id.edtEmail)

        tvOutNombre = findViewById(R.id.tvOutNombre)
        tvOutApellido = findViewById(R.id.tvOutApellido)
        tvOutCelular = findViewById(R.id.tvOutCelular)
        tvOutEdad = findViewById(R.id.tvOutEdad)
        tvOutEmail = findViewById(R.id.tvOutEmail)

        val btnIngresar: Button = findViewById(R.id.btnIngresar)
        btnIngresar.setOnClickListener(this)

        val miListener = clasepropiaOnKeyListener()
        edtNombre.setOnKeyListener(miListener)
        edtApellido.setOnKeyListener(miListener)
        edtCelular.setOnKeyListener(miListener)
        edtEdad.setOnKeyListener(miListener)
        edtEmail.setOnKeyListener(miListener)

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()

        val sharePreferences = getPreferences(Context.MODE_PRIVATE)
        with(sharePreferences.edit()) {
            putString("NOMBRE", edtNombre.text.toString())
            putString("APELLIDO", edtApellido.text.toString())
            putString("CELULAR", edtCelular.text.toString())
            putString("EDAD", edtEdad.text.toString())
            putString("EMAIL", edtEmail.text.toString())
            apply()
        }
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()

        val chBoxBorrar = findViewById<CheckBox>(R.id.chBoxBorrar)
        if (chBoxBorrar.isActivated) {
            val sharedPreferences = getPreferences(Context.MODE_PRIVATE)
            with(sharedPreferences.edit()) {
                clear()
                apply()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    // Clase para enviar informacion con boton
    override fun onClick(view: View?) {
        tvOutNombre.text = "Nombre: " + edtNombre.text.toString()
        tvOutApellido.text = "Apellido: " + edtApellido.text.toString()
        tvOutCelular.text = "Numero: " + edtCelular.text.toString()
        val edad = edtEdad.text.toString().let { if (it.isNotBlank()) it.toInt() else 0 }
        if (edad >= 18) {
            tvOutEdad.text = "Edad: " + edad.toString()
        } else if (edad > 0 && edad < 18) {
            tvOutEdad.text = """
                Edad: ${edad}
                Nota: Menor de edad, requiere autorizacion de un adulto
                """.trimIndent()
        } else {
            tvOutEdad.text = """
                Edad: ${edad}
                Nota! Edad invalida, vuelva a llenar el campo
                """.trimIndent()
        }
        tvOutEmail.text = "Correo: " + edtEmail.text.toString()
        Toast.makeText(applicationContext, "Desde el Boton", Toast.LENGTH_LONG).show()
    }

    // Clase para enviar dato x dato con la flecha enter de teclado
    internal inner class clasepropiaOnKeyListener : View.OnKeyListener {
        override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                when (view.getId()) {
                    R.id.edtNombre -> tvOutNombre.text = "Nombre: " + edtNombre.text.toString()
                    R.id.edtApellido -> tvOutApellido.text =
                        "Apellido: " + edtApellido.text.toString()
                    R.id.edtCelular -> tvOutCelular.text = "Numero: " + edtCelular.text.toString()
                    R.id.edtEdad -> {
                        val edad =
                            edtEdad.text.toString().let { if (it.isNotBlank()) it.toInt() else 0 }
                        if (edad >= 18) {
                            tvOutCelular.text = "Edad: " + edtEdad.text.toString()
                        } else if (edad > 0 && edad < 18) {
                            tvOutCelular.text = """
                                Edad: ${edtEdad.text}
                                Nota: Menor de edad, requiere autorizacion de un adulto
                                """.trimIndent()
                        } else {
                            tvOutCelular.text = """
                                Edad: ${edtEdad.text}
                                Nota: Edad invalida, vuelva a llenar el campo
                                """.trimIndent()
                        }
                    }
                    R.id.edtEmail -> tvOutEmail.text = "Correo: " + edtEmail.text.toString()
                }
                return true
            }
            return false
        }
    }
}