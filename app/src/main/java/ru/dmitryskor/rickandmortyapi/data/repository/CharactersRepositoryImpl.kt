package ru.dmitryskor.rickandmortyapi.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.dmitryskor.rickandmortyapi.data.datasource.RemoteCharacterPagingDataSource
import ru.dmitryskor.rickandmortyapi.data.model.CharacterResponse
import ru.dmitryskor.rickandmortyapi.domain.repository.CharactersRepository

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class CharactersRepositoryImpl(
    private val remoteDataSource: RemoteCharacterPagingDataSource
) : CharactersRepository {
    override fun getCharacters(): Flow<PagingData<CharacterResponse>> {
        return Pager(PagingConfig(
            pageSize = 3
        )) {
            remoteDataSource
        }.flow
    }
}