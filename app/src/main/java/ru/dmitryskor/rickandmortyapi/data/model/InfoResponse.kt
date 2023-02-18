package ru.dmitryskor.rickandmortyapi.data.model

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
data class InfoResponse(
    val count: Int?,
    val pages: Int?,
    val next: String?,
    val prev: String?,
)
