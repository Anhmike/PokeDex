package com.adammcneilly.pokedex.data.remote

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.adammcneilly.pokedex.models.Pokemon
import kotlinx.coroutines.CoroutineScope

class PokemonDataSourceFactory(
    private val pokemonAPI: PokemonAPI,
    private val scope: CoroutineScope

) : DataSource.Factory<Int, Pokemon>() {
    private lateinit var dataSource: PokemonPagingDatasource
    val pokemonDataSource = MutableLiveData<PokemonPagingDatasource>()

    override fun create(): DataSource<Int, Pokemon> {
        dataSource = PokemonPagingDatasource(
            pokemonAPI = pokemonAPI,
            scope = scope
        )
        pokemonDataSource.value = dataSource
        return dataSource
    }
}