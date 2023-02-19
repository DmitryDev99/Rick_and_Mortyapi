package ru.dmitryskor.rickandmortyapi.presentation.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.flow.Flow
import ru.dmitryskor.rickandmortyapi.core.ui.MainTopBar
import ru.dmitryskor.rickandmortyapi.presentation.model.CharacterUIEntity

/**
 * Created by Dmitry Skorodumov on 19.02.2023
 */

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CharactersListScreen(
    viewModel: CharactersListViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            MainTopBar()
        },
        content = { padding ->
            CharactersList(characters = viewModel.characters, padding)
        })
}

@Composable
fun CharactersList(characters: Flow<PagingData<CharacterUIEntity>>, padding: PaddingValues) {
    val charactersItem: LazyPagingItems<CharacterUIEntity> = characters.collectAsLazyPagingItems()
    LazyColumn(content = {
        items(charactersItem) { item ->
            item?.let {
                CharacterItem(it)
            }
        }
    },
    modifier = Modifier.padding(paddingValues = padding))
}

@Composable
fun CharacterItem(item: CharacterUIEntity) {
    Text(text = item.status.name, modifier = Modifier.fillMaxWidth())
}
