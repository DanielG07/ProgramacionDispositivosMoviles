package com.danielg7.practica5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.danielg7.practica5.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.math.pow

enum class Operaciones {
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    CUADRDAO,
    RAIZ,
    RECIPROCO,
    PORCENTAJE,
    ESPERA,
    NINGUNA
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    var tmp: Double = 0.0
    var operacion: Operaciones = Operaciones.NINGUNA
    lateinit var texto: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        texto = binding.tvCalculadora.text.toString()


        binding.btnC.setOnClickListener {
            binding.tvCalculadora.text = "0"
            operacion = Operaciones.NINGUNA
            tmp = 0.0
            texto = "0"
        }

        binding.btnCE.setOnClickListener {
            binding.tvCalculadora.text = "0"
            texto = "0"
        }

        binding.btnBorrar.setOnClickListener {
            binding.tvCalculadora.run {
                if (texto != "0") {
                    text = texto.dropLast(1)
                    texto = texto.dropLast(1)
                }
                if (texto == "") {
                    text = "0"
                    texto = "0"
                }
            }
        }

        binding.btnCero.setOnClickListener { addNumber("0") }
        binding.btnUno.setOnClickListener { addNumber("1") }
        binding.btnDos.setOnClickListener { addNumber("2") }
        binding.btnTres.setOnClickListener { addNumber("3") }
        binding.btnCuatro.setOnClickListener { addNumber("4") }
        binding.btnCinco.setOnClickListener { addNumber("5") }
        binding.btnSeis.setOnClickListener { addNumber("6") }
        binding.btnSiete.setOnClickListener { addNumber("7") }
        binding.btnOcho.setOnClickListener { addNumber("8") }
        binding.btnNueve.setOnClickListener { addNumber("9") }
        binding.btnPunto.setOnClickListener { addNumber(".") }

        binding.btnSigno.setOnClickListener {
            texto = (texto.toDouble()*-1).toString()
            binding.tvCalculadora.text = texto
        }

        binding.btnSuma.setOnClickListener { operacion(Operaciones.SUMA) }
        binding.btnResta.setOnClickListener { operacion(Operaciones.RESTA) }
        binding.btnMultiplicacion.setOnClickListener { operacion(Operaciones.MULTIPLICACION) }
        binding.btnDivision.setOnClickListener { operacion(Operaciones.DIVISION) }
        binding.btnPorciento.setOnClickListener { operacion(Operaciones.PORCENTAJE) }
        binding.btnReciproco.setOnClickListener {
            operacion(Operaciones.RECIPROCO)
            resultado()
        }
        binding.btnCuadrado.setOnClickListener {
            operacion(Operaciones.CUADRDAO)
            resultado()
        }
        binding.btnRaiz.setOnClickListener {
            operacion(Operaciones.RAIZ)
            resultado()
        }

        binding.btnResultado.setOnClickListener { resultado() }
    }

    fun addNumber(number: String) {
        if ((texto.contains(".") && number == ".")) return
        if (operacion == Operaciones.NINGUNA || texto.isEmpty()) {
            operacion = Operaciones.ESPERA
            texto = "0"
        }
        if (texto.toDouble() == 0.0 && number != "." && !texto.contains(".")) {
            texto = ""
        }
        if (texto.length < 9) {
            texto += number
            binding.tvCalculadora.text = texto
        } else {
            Toast.makeText(this, "Solo se pueden números de 9 dígitos", Toast.LENGTH_LONG).show()
        }
    }

    fun operacion(operacion: Operaciones) {
        tmp = texto.toDouble()
        texto = "0"
        this.operacion = operacion
        binding.tvCalculadora.text = texto
    }

    fun resultado() {
        when (operacion) {
            Operaciones.SUMA -> {
                tmp += texto.toDouble()
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            Operaciones.RESTA -> {
                tmp -= texto.toDouble()
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            Operaciones.MULTIPLICACION -> {
                tmp *= texto.toDouble()
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            Operaciones.DIVISION -> {
                tmp /= texto.toDouble()
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            Operaciones.CUADRDAO -> {
                tmp *= tmp
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            Operaciones.RAIZ -> {
                tmp = tmp.pow(0.5)
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            Operaciones.RECIPROCO -> {
                tmp = 1 / tmp
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            Operaciones.PORCENTAJE -> {
                tmp = tmp * texto.toDouble() / 100
                texto = DecimalFormat("#.###").format(tmp).toString()
            }
            else -> {
                Toast.makeText(this, "Ingresa algun numero", Toast.LENGTH_LONG).show()
            }
        }
        operacion = Operaciones.NINGUNA
        binding.tvCalculadora.text = texto
    }
}