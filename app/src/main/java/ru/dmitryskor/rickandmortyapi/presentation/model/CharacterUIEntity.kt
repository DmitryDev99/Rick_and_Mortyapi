package ru.dmitryskor.rickandmortyapi.presentation.model

import android.content.Context
import androidx.annotation.StringRes
import ru.dmitryskor.rickandmortyapi.R

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
data class CharacterUIEntity(
    val id: Int?,
    private val name: String?,
    val status: StatusUICharacter,
    private val species: String?,
    @StringRes private val gender: Int,
    val imageLink: String?,
) {
    fun getNameCharacter(context: Context): String {
        return "${name ?: context.getString(R.string.unknown_name)} - ${
            if (species.isNullOrEmpty() || species == "unknown") {
                context.getString(R.string.unknown_species)
            } else {
                species
            }
        }"
    }

    fun getGender(context: Context): String {
        return "${context.getString(R.string.gender)}: ${context.getString(gender)}"
    }
}