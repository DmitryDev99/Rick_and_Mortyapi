package ru.dmitryskor.rickandmortyapi.domain.interactor

import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.dmitryskor.rickandmortyapi.core.map.Mapper
import ru.dmitryskor.rickandmortyapi.data.model.CharacterResponse
import ru.dmitryskor.rickandmortyapi.domain.model.CharacterEntity
import ru.dmitryskor.rickandmortyapi.domain.repository.CharactersRepository

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class GetCharacterUseCase(
    private val repository: CharactersRepository,
    private val mapper: Mapper<CharacterResponse, CharacterEntity>
) {
    fun invoke(): Flow<PagingData<CharacterEntity>> {
        return repository.getCharacters().map { pagingData ->
            pagingData.map {
                mapper.map(it)
            }
        }
    }
}