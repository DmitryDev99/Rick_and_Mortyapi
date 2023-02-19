package ru.dmitryskor.rickandmortyapi.core.network

import com.google.gson.Gson

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */
object ProviderGson {
    private var gson: Gson? = null

    fun getGson(): Gson {
        if (gson == null) {
            gson = Gson()
        }
        return gson!!
    }
}