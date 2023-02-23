package com.example.fastcryptocurrencyviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fastcryptocurrencyviewer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *  Inyeccion de dependencias con Hilt y arquitectura limpia
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}