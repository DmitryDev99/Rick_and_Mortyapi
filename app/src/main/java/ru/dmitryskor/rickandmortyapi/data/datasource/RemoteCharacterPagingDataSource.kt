package ru.dmitryskor.rickandmortyapi.data.datasource

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import retrofit2.HttpException
import ru.dmitryskor.rickandmortyapi.core.network.AppService
import ru.dmitryskor.rickandmortyapi.core.utils.network.parseJson
import ru.dmitryskor.rickandmortyapi.data.model.CharacterResponse
import ru.dmitryskor.rickandmortyapi.data.model.PageCharacterResponse

/**
 * Created by Dmitry Skorodumov on 18.02.2023
 */
class RemoteCharacterPagingDataSource(
    private val service: AppService
) : PagingSource<Int, CharacterResponse>() {
    override fun getRefreshKey(state: PagingState<Int, CharacterResponse>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterResponse> {
        return try {
            val page = params.key ?: 1
            val response = service.get("character", mapOf("page" to page.toString()))
            if (response.isSuccessful) {
                val pageResponse = response.body()?.parseJson<PageCharacterResponse>()
                val characters = pageResponse?.results
                val nextKey = getPage(pageResponse?.info?.next)
                val prevKey = getPage(pageResponse?.info?.prev)

                LoadResult.Page(
                    data = characters.orEmpty(),
                    prevKey = prevKey,
                    nextKey = nextKey
                )
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (t: Throwable) {
            LoadResult.Error(t)
        }
    }

    private fun getPage(url: String?): Int? {
        if (url.isNullOrEmpty()) return null

        val uri = Uri.parse(url)
        val page = uri.getQueryParameter("page")
        return page?.toInt()
    }
}