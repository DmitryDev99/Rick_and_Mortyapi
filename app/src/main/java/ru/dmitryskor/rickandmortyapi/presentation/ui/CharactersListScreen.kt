package ru.dmitryskor.rickandmortyapi.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import kotlinx.coroutines.flow.Flow
import ru.dmitryskor.rickandmortyapi.R
import ru.dmitryskor.rickandmortyapi.core.ui.MainTopBar
import ru.dmitryskor.rickandmortyapi.core.ui.error.ErrorView
import ru.dmitryskor.rickandmortyapi.core.ui.loading.LoadingItem
import ru.dmitryskor.rickandmortyapi.core.ui.loading.LoadingView
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
    LazyColumn(
        content = {
            items(charactersItem) { item ->
                item?.let {
                    CharacterItem(it)
                }
            }
            charactersItem.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item { LoadingView(Modifier.fillParentMaxSize()) }
                    }
                    loadState.append is LoadState.Loading -> {
                        item { LoadingItem() }
                    }
                    loadState.refresh is LoadState.Error -> {
                        item {
                            ErrorView(
                                message = (loadState.refresh as LoadState.Error).error.localizedMessage
                                    ?: stringResource(id = R.string.error_default),
                                modifier = Modifier.fillParentMaxSize(),
                                onClickRetry = { retry() }
                            )
                        }
                    }
                    loadState.append is LoadState.Error -> {
                        item {
                            ErrorView(
                                message = (loadState.append as LoadState.Error).error.localizedMessage
                                    ?: stringResource(id = R.string.error_default),
                                modifier = Modifier.fillMaxWidth(),
                                onClickRetry = { retry() }
                            )
                        }
                    }
                }
            }
        },
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        contentPadding = padding,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    )
}

@Composable
fun CharacterItem(item: CharacterUIEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        CharacterImage(item.imageLink)
        Spacer(modifier = Modifier.size(16.dp))
        Column {
            Text(
                text = item.getNameCharacter(LocalContext.current),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.size(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(colorResource(id = item.status.color))
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(text = stringResource(id = item.status.nameStatus))
            }
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = item.getGender(LocalContext.current))
        }
    }
}

@Composable
fun CharacterImage(url: String?) {
    AsyncImage(
        model = url,
        placeholder = painterResource(id = R.drawable.placeholder_characters),
        contentDescription = null,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(12.dp)),
        contentScale = ContentScale.Crop
    )
}
