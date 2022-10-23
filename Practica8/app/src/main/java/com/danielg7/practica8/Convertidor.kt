package com.danielg7.practica8

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.danielg7.practica8.databinding.ActivityConvertidorBinding

class Convertidor : AppCompatActivity() {

    lateinit var binding: ActivityConvertidorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConvertidorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFC.setOnClickListener {
            val fahrenheit = binding.edtFC.text
            if(fahrenheit.isNotBlank()) {
                if (fahrenheit != null) FahrenheitToCelsiusClick(fahrenheit.toString())
            }
        }

        binding.btnCF.setOnClickListener {
            val celsius = binding.edtCF.text
            if(celsius.isNotBlank()) {
                if (celsius != null) CelsiusToFahrenheitClick(celsius.toString())
            }
        }

        binding.btnLimpiar.setOnClickListener {
            binding.tvCFResultado.text = ""
            binding.tvFCResultado.text = ""
        }


        val onKeyListener = OnKeyListener()
        binding.edtCF.setOnKeyListener(onKeyListener)
        binding.edtFC.setOnKeyListener(onKeyListener)

    }

    fun CelsiusToFahrenheitClick(celsius: String) {
        val fahrenheit = CelsiusToFahrenheit(celsius.toDouble())
        val text = getString(R.string.c_f_result, fahrenheit.toString())
        binding.tvCFResultado.text = text
    }

    fun FahrenheitToCelsiusClick(fahrenheit: String) {
        val celsius = FahrenheitToCelsius(fahrenheit.toDouble())
        val text = getString(R.string.f_c_result, celsius.toString())
        binding.tvFCResultado.text = text

    }

    private fun CelsiusToFahrenheit(celsius: Double): Double {
        return celsius * 1.8 + 32
    }

    private fun FahrenheitToCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32) / 1.8
    }

    companion object {
        fun startActivity(context: Context) {
            Toast.makeText(context, "Navegando a Convertidor de grados", Toast.LENGTH_SHORT).show()

            val intent = Intent(context, Convertidor::class.java)
            context.startActivity(intent)
        }
    }

    internal inner class OnKeyListener : View.OnKeyListener {
        override fun onKey(view: View, i: Int, keyEvent: KeyEvent): Boolean {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER) {
                when (view.getId()) {
                    R.id.edtCF -> {
                        val celsius = binding.edtCF.text
                        if(celsius.isNotBlank()) {
                            if (celsius != null) CelsiusToFahrenheitClick(celsius.toString())
                        }
                    }
                    R.id.edtFC ->{
                        val fahrenheit = binding.edtFC.text
                        if(fahrenheit.isNotBlank()) {
                            if (fahrenheit != null) FahrenheitToCelsiusClick(fahrenheit.toString())
                        }
                    }
                }
                return true
            }
            return false
        }
    }
}