package com.lcarlosfb.p0.presentation.notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lcarlosfb.p0.databinding.ActivityNotasBinding

class NotasActivity : AppCompatActivity() {

	private lateinit var notasBinding : ActivityNotasBinding
	private lateinit var notasViewModel : NotasViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		notasBinding = ActivityNotasBinding.inflate(layoutInflater)
		notasViewModel = ViewModelProvider(this)[NotasViewModel::class.java]
		val view = notasBinding.root
		setContentView(view)

		val validarCamposObserver = Observer<String>{ nError ->
			Toast.makeText(applicationContext, nError, Toast.LENGTH_SHORT).show()
		}
		notasViewModel.nError.observe(this, validarCamposObserver)

		val sumTotalObserver = Observer <Float> {total ->
			notasBinding.tvResult.setText(total.toString())
		}
		notasViewModel.total.observe(this, sumTotalObserver)


		notasBinding.btnCalcular.setOnClickListener {
			val (nota1, nota2, nota3, nota4) = leerDatos()
			notasViewModel.calcular(nota1,nota2,nota3,nota4)
		}

		notasBinding.btnReset.setOnClickListener {
			limpiar()
		}
	}

	private fun leerDatos(): Array<String> {
		val nota1 : String = notasBinding.edtLab.text.toString()
		val nota2 : String = notasBinding.edtPrimerAvance.text.toString()
		val nota3 : String = notasBinding.edtSegundoAvance.text.toString()
		val nota4 : String = notasBinding.edtProyectoFinal.text.toString()
		return arrayOf(nota1,nota2,nota3,nota4)
	}

	private fun limpiar() {
		notasBinding.tvResult.setText("0")
		notasBinding.edtPrimerAvance.setText("")
		notasBinding.edtSegundoAvance.setText("")
		notasBinding.edtProyectoFinal.setText("")
		notasBinding.edtLab.setText("")
	}
}

//Punto 1 de la version 1.0 terminado

//Punto 1 de la version 2.0 terminado