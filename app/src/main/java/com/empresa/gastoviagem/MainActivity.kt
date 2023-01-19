package com.empresa.gastoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.INFO
import android.view.View
import android.widget.Toast
import com.empresa.gastoviagem.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.time.Duration
import java.util.logging.Logger

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if (view.id == R.id.btn_calcular) {
            calcular()
        }
    }

    private fun isValid(): Boolean {
        return (binding.editAutonomia.text.toString() != ""
                && binding.editDistancia.text.toString() != ""
                && binding.editPreco.text.toString() != "")
    }

    private fun calcular() {
        if (isValid()) {
            val distancia = binding.editDistancia.text.toString().toBigDecimal()
            val preco = binding.editPreco.text.toString().toBigDecimal()
            val autonomia = binding.editAutonomia.text.toString().toBigDecimal()


            val resultado = distancia.multiply(preco).divide(autonomia)

            val valorTotal = "R$ ${"%.2f".format(resultado)}"

            binding.textResultado.text = valorTotal
        } else {
            Toast.makeText(this,R.string.preencher_campos, Toast.LENGTH_LONG)
                .show()

        }


    }


}