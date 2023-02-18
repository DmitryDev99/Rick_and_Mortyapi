package ru.dmitryskor.rickandmortyapi.data.model

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
data class PageResponse(
    val info: InfoResponse?,
    val results: List<CharacterResponse?> = emptyList()
)