package com.lcarlosfb.p0.presentation.notas

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.roundToInt

class NotasViewModel : ViewModel(){

	val nError : MutableLiveData<String> by lazy{
		MutableLiveData<String>()
	}

	val total : MutableLiveData<Float> by lazy{
		MutableLiveData<Float>()
	}

	 fun calcular (n1:String, n2:String, n3:String, n4:String) {
		 if (n1.isEmpty() || n2.isEmpty() || n3.isEmpty() || n4.isEmpty()){
			 nError.value = "Llenar campos vacios"
		 }else if((n1.toFloat() > 5 || n1.toFloat() <0) || (n2.toFloat() > 5 || n2.toFloat() <0) ||
			 (n3.toFloat() > 5 || n3.toFloat() <0) || (n4.toFloat() > 5 || n4.toFloat() <0) ){
			 nError.value = "Sólo se admiten notas entre 0 y 5"
		 }else {
			 total.value = (((n1.toFloat() * 0.6) + (n2.toFloat() * 0.07) + (n3.toFloat() * 0.08) +
					 (n4.toFloat() * 0.25))*1000).roundToInt().toFloat()/1000
		 }
	 }
}
//Subiendo el viewModel que no lo vi en el repositorio