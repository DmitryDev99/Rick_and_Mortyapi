package ru.dmitryskor.rickandmortyapi.presentation.mapper

import ru.dmitryskor.rickandmortyapi.core.map.Mapper
import ru.dmitryskor.rickandmortyapi.domain.model.CharacterEntity
import ru.dmitryskor.rickandmortyapi.domain.model.StatusCharacter
import ru.dmitryskor.rickandmortyapi.presentation.model.CharacterUIEntity
import ru.dmitryskor.rickandmortyapi.presentation.model.StatusUICharacter

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class CharactersUIMapper : Mapper<CharacterEntity, CharacterUIEntity>() {
    override fun map(from: CharacterEntity): CharacterUIEntity {
        return CharacterUIEntity(
            from.id,
            from.name,
            when (from.statusCharacter) {
                StatusCharacter.ALIVE -> StatusUICharacter.ALIVE
                StatusCharacter.DEAD -> StatusUICharacter.DEAD
                StatusCharacter.UNKNOWN -> StatusUICharacter.UNKNOWN
            },
            from.species,
            from.genderCharacter.name.lowercase().replaceFirstChar { it.uppercase() },
            from.imageLink
        )
    }
}