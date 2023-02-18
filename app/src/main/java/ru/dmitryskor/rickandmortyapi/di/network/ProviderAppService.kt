package ru.dmitryskor.rickandmortyapi.di.network

import retrofit2.Retrofit
import ru.dmitryskor.rickandmortyapi.core.network.AppService
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
object ProviderAppService {
    private var retrofit: AppService? = null
    private const val HOST_NAME = "https://rickandmortyapi.com/api/"

    fun getAppService(): AppService {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(ProviderGsonBuilder.getGsonBuilder().create()))
                .baseUrl(HOST_NAME)
                .build()
                .create(AppService::class.java)
        }
        return retrofit!!
    }
}