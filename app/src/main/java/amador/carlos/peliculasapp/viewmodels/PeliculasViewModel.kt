package amador.carlos.peliculasapp.viewmodels

import amador.carlos.peliculasapp.R
import amador.carlos.peliculasapp.modelos.Pelicula
import amador.carlos.peliculasapp.modelos.PeliculaRepositorio
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.collections.emptyList
import kotlin.math.sin

class PeliculasViewModel(val repo: PeliculaRepositorio): ViewModel() {
    private val _peliculas = mutableStateOf<List<Pelicula>>(emptyList())
    val peliculas: State<List<Pelicula>> = _peliculas

    init {
        getPeliculas()
    }

    private fun getPeliculas() {
        _peliculas.value = repo.getPeliculas()
    }

    fun agregaPelicula(titulo: String, categoria: String, duracion:String, sinopsis:String, fotoURI: String?){
        val nuevoID = _peliculas.value.size + 1
        val pelicula = Pelicula(
            nuevoID,
            titulo,
            categoria,
            duracion,
            sinopsis,
            R.drawable.tabler_movie,
            fotoURI

        )
        repo.agregarPelicula(pelicula)
        _peliculas.value = repo.getPeliculas()
    }

    fun eliminarPelicula(peliculaID: Int){
        repo.eliminarPelicula(peliculaID)
        _peliculas.value = repo.getPeliculas()
    }

    fun editarPelicula(id: Int ,titulo: String, categoria: String, duracion:String, sinopsis:String, fotoURI: String?) {
        val peli = Pelicula(id,titulo,categoria,duracion, sinopsis,R.drawable.tabler_movie, fotoURI)
        repo.editarPelicula(peli)
        _peliculas.value = repo.getPeliculas()
    }
}
