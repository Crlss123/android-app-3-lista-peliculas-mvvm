package amador.carlos.peliculasapp.vistas

import amador.carlos.peliculasapp.modelos.Usuario
import amador.carlos.peliculasapp.viewmodels.UsuarioViewModel
import android.widget.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UsuarioScreen(viewModel: UsuarioViewModel) {
    val usuarios = viewModel.usuario.value

    Scaffold(

    ) {
        padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            items(usuarios){usuario ->
                UsuarioCard(usuario)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun UsuarioCard(usuario: Usuario) {
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            Text(text = usuario.nombre)
            Text(text = usuario.correo)
            Text(text = usuario.edad.toString())
        }
    }
}