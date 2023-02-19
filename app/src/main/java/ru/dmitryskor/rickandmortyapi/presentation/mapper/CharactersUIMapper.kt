package ru.dmitryskor.rickandmortyapi.presentation.mapper

import ru.dmitryskor.rickandmortyapi.R
import ru.dmitryskor.rickandmortyapi.core.map.Mapper
import ru.dmitryskor.rickandmortyapi.domain.model.CharacterEntity
import ru.dmitryskor.rickandmortyapi.domain.model.GenderCharacter
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
            when (from.genderCharacter) {
                GenderCharacter.FEMALE -> R.string.female_gender
                GenderCharacter.MALE -> R.string.male_gender
                GenderCharacter.GENDERLESS -> R.string.genderless
                GenderCharacter.UNKNOWN -> R.string.unknown_gender
            },
            from.imageLink
        )
    }
}