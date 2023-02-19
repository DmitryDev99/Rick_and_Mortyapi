package ru.dmitryskor.rickandmortyapi.data.network

import ru.dmitryskor.rickandmortyapi.core.network.AppService
import ru.dmitryskor.rickandmortyapi.core.network.BaseService

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 *
 * Сервис для получения рик и морти api
 */
object CharactersService : BaseService() {
    override var appService: AppService? = null
    override val hostName = "https://rickandmortyapi.com/api/"
}
