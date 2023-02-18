package ru.dmitryskor.rickandmortyapi.presentation.mapper

import ru.dmitryskor.rickandmortyapi.core.map.Mapper
import ru.dmitryskor.rickandmortyapi.domain.model.CharacterEntity
import ru.dmitryskor.rickandmortyapi.presentation.model.CharacterUIEntity

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class CharactersUIMapper : Mapper<CharacterEntity, CharacterUIEntity>() {
    override fun map(from: CharacterEntity): CharacterUIEntity {
        return CharacterUIEntity()
    }
}