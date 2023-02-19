package ru.dmitryskor.rickandmortyapi.core.utils.network

import com.google.gson.JsonObject
import ru.dmitryskor.rickandmortyapi.core.network.ProviderGson

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */
inline fun <reified T> JsonObject.parseJson(): T {
    return ProviderGson.getGson().fromJson(this, T::class.java)
}