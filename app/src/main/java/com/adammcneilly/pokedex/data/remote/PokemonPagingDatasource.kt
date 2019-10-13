package com.adammcneilly.pokedex.data.remote

import androidx.paging.PageKeyedDataSource
import com.adammcneilly.pokedex.DispatcherProvider
import com.adammcneilly.pokedex.models.Pokemon
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PokemonPagingDatasource(
    private val pokemonAPI: PokemonAPI,
    private val scope: CoroutineScope,
    private val dispatcherProvider: DispatcherProvider = DispatcherProvider()
) : PageKeyedDataSource<Int, Pokemon>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Pokemon>
    ) {
        scope.launch(dispatcherProvider.IO) {
            val response = pokemonAPI.getPokemonAsync(offset = 0).await()
            callback.onResult(
                response.results.orEmpty(),
                null,
                response.nextKey
            )
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Pokemon>
    ) {
        val offset = params.key

        scope.launch(dispatcherProvider.IO) {
            val response = pokemonAPI.getPokemonAsync(offset = offset).await()
            callback.onResult(
                response.results.orEmpty(),
                response.nextKey
            )
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Pokemon>
    ) {
        // Not needed
    }
}