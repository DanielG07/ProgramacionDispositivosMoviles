package com.danielg7.practica5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.danielg7.practica5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnC.setOnClickListener {
            binding.tvCalculadora.text = "0"
        }

        binding.btnCE.setOnClickListener {
            binding.tvCalculadora.text = "0"
        }

        binding.btnBorrar.setOnClickListener {
            binding.tvCalculadora.run{
                text = text.dropLast(1)
            }
        }

        binding.btnCero.setOnClickListener{ addNumber("0") }
        binding.btnUno.setOnClickListener{ addNumber("1") }
        binding.btnDos.setOnClickListener{ addNumber("2") }
        binding.btnTres.setOnClickListener{ addNumber("3") }
        binding.btnCuatro.setOnClickListener{ addNumber("4") }
        binding.btnCinco.setOnClickListener{ addNumber("5") }
        binding.btnSeis.setOnClickListener{ addNumber("6") }
        binding.btnSiete.setOnClickListener{ addNumber("7") }
        binding.btnOcho.setOnClickListener{ addNumber("8") }
        binding.btnNueve.setOnClickListener{ addNumber("9") }
    }

    fun addNumber(number: String) {
        var texto = binding.tvCalculadora.text.toString()
        if(texto.toInt() == 0) {
            texto = ""
        }
        if(texto.length < 9){
            texto += number
            binding.tvCalculadora.text = texto
        } else {
            Toast.makeText(this, "Solo se pueden números de 9 dígitos", Toast.LENGTH_LONG).show()
        }
    }
}