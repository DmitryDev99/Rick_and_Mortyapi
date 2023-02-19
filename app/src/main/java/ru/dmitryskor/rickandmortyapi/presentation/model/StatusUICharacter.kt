package ru.dmitryskor.rickandmortyapi.presentation.model

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import ru.dmitryskor.rickandmortyapi.R

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */
enum class StatusUICharacter(@ColorRes val color: Int, @StringRes val nameStatus: Int) {
    ALIVE(R.color.positive_case, R.string.alive_status),
    DEAD(R.color.negative_case, R.string.dead_status),
    UNKNOWN(R.color.neutral_case, R.string.unknown_status),
}