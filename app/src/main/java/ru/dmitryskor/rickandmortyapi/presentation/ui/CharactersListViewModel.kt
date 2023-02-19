package ru.dmitryskor.rickandmortyapi.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import ru.dmitryskor.rickandmortyapi.data.datasource.RemoteCharacterPagingDataSource
import ru.dmitryskor.rickandmortyapi.data.network.CharactersService
import ru.dmitryskor.rickandmortyapi.data.repository.CharactersRepositoryImpl
import ru.dmitryskor.rickandmortyapi.domain.interactor.GetCharacterUseCase
import ru.dmitryskor.rickandmortyapi.domain.mapper.CharactersMapper
import ru.dmitryskor.rickandmortyapi.presentation.mapper.CharactersUIMapper
import ru.dmitryskor.rickandmortyapi.presentation.model.CharacterUIEntity

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class CharactersListViewModel : ViewModel() {

    private val repository = CharactersRepositoryImpl(
        RemoteCharacterPagingDataSource(CharactersService.getService())
    )

    val characters: StateFlow<PagingData<CharacterUIEntity>> =
        GetCharacterUseCase(
            repository, CharactersMapper()
        ).invoke().map { pagingData ->
            pagingData.map {
                CharactersUIMapper().map(it)
            }
        }
            .cachedIn(viewModelScope)
            .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}