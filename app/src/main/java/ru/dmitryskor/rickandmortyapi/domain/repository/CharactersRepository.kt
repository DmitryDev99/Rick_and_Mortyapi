package ru.dmitryskor.rickandmortyapi.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.dmitryskor.rickandmortyapi.data.model.CharacterResponse

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
interface CharactersRepository {
    fun getCharacters(): Flow<PagingData<CharacterResponse>>
}