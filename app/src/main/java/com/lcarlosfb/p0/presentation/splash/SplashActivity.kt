package com.lcarlosfb.p0.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lcarlosfb.p0.R
import com.lcarlosfb.p0.databinding.ActivitySplashBinding
import com.lcarlosfb.p0.presentation.notas.NotasActivity
import java.util.Timer
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

	private lateinit var splashBinding: ActivitySplashBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		splashBinding = ActivitySplashBinding.inflate(layoutInflater)
		val view = splashBinding.root
		setContentView(view)

	val timer = Timer()
	timer.schedule(timerTask {
		val intent = Intent(this@SplashActivity, NotasActivity::class.java)
		startActivity(intent)
		finish()
	}, 2000)

	}
}