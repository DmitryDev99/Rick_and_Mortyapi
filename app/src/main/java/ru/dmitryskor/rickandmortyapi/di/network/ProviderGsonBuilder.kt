package ru.dmitryskor.rickandmortyapi.di.network

import com.google.gson.GsonBuilder

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
object ProviderGsonBuilder {
    private var gson: GsonBuilder? = null

    fun getGsonBuilder(): GsonBuilder {
        if (gson == null) {
            gson = GsonBuilder()
                .serializeNulls()
                .setPrettyPrinting()
        }
        return gson!!
    }
}