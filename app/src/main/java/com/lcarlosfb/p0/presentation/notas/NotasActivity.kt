package com.lcarlosfb.p0.presentation.notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lcarlosfb.p0.databinding.ActivityNotasBinding
import kotlin.math.roundToInt

class NotasActivity : AppCompatActivity() {

	private lateinit var notasBinding: ActivityNotasBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		notasBinding = ActivityNotasBinding.inflate(layoutInflater)
		val view = notasBinding.root
		setContentView(view)

		notasBinding.btnCalcular.setOnClickListener {

			val nota1 : String = notasBinding.edtLab.text.toString()
			val nota2 : String = notasBinding.edtPrimerAvance.text.toString()
			val nota3 : String = notasBinding.edtSegundoAvance.text.toString()
			val nota4 : String = notasBinding.edtProyectoFinal.text.toString()

			if (nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() || nota4.isEmpty())
				Toast.makeText(applicationContext, "Hay campos vacios", Toast.LENGTH_SHORT).show()

			else{
				val suma = (((nota1.toFloat() * 0.6) + (nota2.toFloat() * 0.07) + (nota3.toFloat() * 0.08) +
						(nota4.toFloat() * 0.25))*1000).roundToInt().toDouble()/1000

				notasBinding.tvResult.setText(suma.toString())
			}

		notasBinding.btnReset.setOnClickListener {

			notasBinding.tvResult.setText("0")
			notasBinding.edtPrimerAvance.setText("")
			notasBinding.edtSegundoAvance.setText("")
			notasBinding.edtProyectoFinal.setText("")
			notasBinding.edtLab.setText("")

		}

		}

	}
}