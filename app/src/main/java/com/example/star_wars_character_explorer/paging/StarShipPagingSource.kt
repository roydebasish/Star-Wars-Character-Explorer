package com.example.star_wars_character_explorer.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.star_wars_character_explorer.service.model.StarShip
import com.example.star_wars_character_explorer.service.network.StarWarsApi
import java.lang.Exception

class StarShipPagingSource(val starWarsApi: StarWarsApi) : PagingSource<Int, StarShip>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, StarShip> {

        return try {
            val position = params.key ?: 1
            val response = starWarsApi.getStarShips(position)

            LoadResult.Page(
                data = response.results,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == 4) null else position + 1,
            )
        }catch (e : Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, StarShip>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }

}