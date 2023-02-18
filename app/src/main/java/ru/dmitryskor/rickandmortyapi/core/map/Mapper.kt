package ru.dmitryskor.rickandmortyapi.core.map

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */

abstract class Mapper<From, To> {
    abstract fun map(from: From): To
}