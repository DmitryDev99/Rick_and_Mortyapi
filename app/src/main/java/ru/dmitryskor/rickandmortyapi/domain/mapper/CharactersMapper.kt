package ru.dmitryskor.rickandmortyapi.domain.mapper

import ru.dmitryskor.rickandmortyapi.core.map.Mapper
import ru.dmitryskor.rickandmortyapi.data.model.CharacterResponse
import ru.dmitryskor.rickandmortyapi.domain.model.CharacterEntity

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */
class CharactersMapper: Mapper<CharacterResponse, CharacterEntity>() {
    override fun map(from: CharacterResponse): CharacterEntity {
        return CharacterEntity(
            from.id,
            from.name
        )
    }
}