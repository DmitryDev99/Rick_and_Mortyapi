package ru.dmitryskor.rickandmortyapi.core.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.dmitryskor.rickandmortyapi.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}