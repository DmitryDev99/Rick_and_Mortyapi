package ru.dmitryskor.rickandmortyapi.data.network

import retrofit2.http.GET

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
interface CharacterService {

    @GET
    fun get()
}