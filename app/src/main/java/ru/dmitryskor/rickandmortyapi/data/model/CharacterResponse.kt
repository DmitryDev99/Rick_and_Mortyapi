package ru.dmitryskor.rickandmortyapi.data.model

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
data class CharacterResponse(
    val id: Int?,
    val name: String?,
    val status: String?,
    val species: String?,
    val type: String?,
    val gender: String?,
    val origin: OriginResponse,
    val location: LocationResponse,
    val image: String?,
    val episode: List<String?> = emptyList(),
    val url: String?,
    val created: String?,
)

data class OriginResponse(
    val name: String?,
    val url: String?,
)

data class LocationResponse(
    val name: String?,
    val url: String?,
)
