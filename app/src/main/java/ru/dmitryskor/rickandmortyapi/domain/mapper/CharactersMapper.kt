package ru.dmitryskor.rickandmortyapi.domain.mapper

import ru.dmitryskor.rickandmortyapi.core.map.Mapper
import ru.dmitryskor.rickandmortyapi.data.model.CharacterResponse
import ru.dmitryskor.rickandmortyapi.domain.model.CharacterEntity
import ru.dmitryskor.rickandmortyapi.domain.model.GenderCharacter
import ru.dmitryskor.rickandmortyapi.domain.model.StatusCharacter

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */
class CharactersMapper: Mapper<CharacterResponse, CharacterEntity>() {
    override fun map(from: CharacterResponse): CharacterEntity {
        return CharacterEntity(
            from.id,
            from.name,
            when (from.status) {
                "Alive" -> StatusCharacter.ALIVE
                "Dead" -> StatusCharacter.DEAD
                else -> StatusCharacter.UNKNOWN
            },
            from.species,
            when (from.gender) {
                "Female" -> GenderCharacter.FEMALE
                "Male" -> GenderCharacter.MALE
                "Genderless" -> GenderCharacter.GENDERLESS
                else -> GenderCharacter.UNKNOWN
            },
            from.image
        )
    }
}