package ru.dmitryskor.rickandmortyapi.core.network

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
abstract class BaseService {
    protected abstract var appService: AppService?
    protected abstract val hostName: String

    open fun getService(): AppService {
        if (appService == null) {
            appService = ProviderRetrofit.getRetrofit().newBuilder()
                .baseUrl(hostName)
                .build()
                .create(AppService::class.java)
        }
        return appService!!
    }
}