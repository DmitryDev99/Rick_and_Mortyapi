package ru.dmitryskor.rickandmortyapi.data.interactor

import ru.dmitryskor.rickandmortyapi.data.entity.CharacterEntity

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class GetCharacterUseCase {
    fun invoke(): CharacterEntity {
        return CharacterEntity()
    }
}