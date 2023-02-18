package ru.dmitryskor.rickandmortyapi.core.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */

interface AppService {

    @GET("{method}")
    suspend fun <T> get(
        @Path(value = "method") method: String,
        @QueryMap params: Map<String, String>
    ): Response<T>
}