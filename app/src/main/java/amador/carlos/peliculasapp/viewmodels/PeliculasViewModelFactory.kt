package amador.carlos.peliculasapp.viewmodels

import amador.carlos.peliculasapp.modelos.PeliculaRepositorio
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PeliculasViewModelFactory(private val repo: PeliculaRepositorio): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PeliculasViewModel::class.java)){
            return PeliculasViewModel(repo) as T
        }

        throw IllegalArgumentException("Desconocido")
    }
}