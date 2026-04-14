package amador.carlos.peliculasapp.viewmodels

import amador.carlos.peliculasapp.modelos.Pelicula
import amador.carlos.peliculasapp.modelos.PeliculaRepositorio
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.collections.emptyList

class PeliculasViewModel(val repo: PeliculaRepositorio): ViewModel() {
    private val _peliculas = mutableStateOf<List<Pelicula>>(emptyList())
    val peliculas: State<List<Pelicula>> = _peliculas

    init {
        getPeliculas()
    }

    private fun getPeliculas() {
        _peliculas.value = repo.getPeliculas()
    }
}