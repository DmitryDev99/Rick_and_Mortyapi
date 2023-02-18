package ru.dmitryskor.rickandmortyapi.domain.interactor

import ru.dmitryskor.rickandmortyapi.domain.model.CharacterEntity

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class GetCharacterUseCase {
    fun invoke(): CharacterEntity {
        return CharacterEntity()
    }
}