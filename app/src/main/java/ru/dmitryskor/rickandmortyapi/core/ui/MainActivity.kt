package ru.dmitryskor.rickandmortyapi.core.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import ru.dmitryskor.rickandmortyapi.R
import ru.dmitryskor.rickandmortyapi.presentation.ui.CharactersListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CharactersListScreen()
        }
    }
}