package amador.carlos.peliculasapp.viewmodels

import amador.carlos.peliculasapp.modelos.RepositorioUsuarios
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class UsuarioViewModelFactory(private val repositorio: RepositorioUsuarios): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // return super.create(modelClass)
        if(modelClass.isAssignableFrom(UsuarioViewModel::class.java)){
            return UsuarioViewModel(repositorio) as T
        }

        throw IllegalArgumentException("Desconocido")
    }

}