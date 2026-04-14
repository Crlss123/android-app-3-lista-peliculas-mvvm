package amador.carlos.peliculasapp.viewmodels

import amador.carlos.peliculasapp.modelos.RepositorioUsuarios
import amador.carlos.peliculasapp.modelos.Usuario
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UsuarioViewModel(val repo: RepositorioUsuarios): ViewModel() {

    private val _usuarios = mutableStateOf<List<Usuario>>(emptyList())
    val usuario: State<List<Usuario>> = _usuarios

    init {
        getUsuarios()
    }

    private fun getUsuarios(){
        _usuarios.value = repo.getUsuarios()
    }

}