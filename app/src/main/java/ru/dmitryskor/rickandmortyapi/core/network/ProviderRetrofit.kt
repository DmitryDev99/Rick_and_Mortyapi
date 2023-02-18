package ru.dmitryskor.rickandmortyapi.core.network

import okhttp3.HttpUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
object ProviderRetrofit {
    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(ProviderGsonBuilder.getGsonBuilder().create()))
                .baseUrl(HttpUrl.get("http://localhost/"))
                .build()
        }
        return retrofit!!
    }
}