package amador.carlos.peliculasapp.vistas

import amador.carlos.peliculasapp.modelos.Pelicula
import amador.carlos.peliculasapp.modelos.Usuario
import amador.carlos.peliculasapp.viewmodels.PeliculasViewModel
import amador.carlos.peliculasapp.viewmodels.UsuarioViewModel
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlin.math.sin

@Composable
fun PeliculasScreen(viewModel: PeliculasViewModel) {
    val peliculas = viewModel.peliculas.value
    var mostrarDialogo by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                mostrarDialogo = true
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar"
                )
            }
        }
    ) {
            padding ->
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(padding)
        ) {
            items(peliculas){pelicula ->
                PeliculaCard(
                    pelicula,
                    onDelete = {
                        viewModel.eliminarPelicula(pelicula.id)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
    if(mostrarDialogo){
        AgregarPeliculaDialog(
            onDismiss = { mostrarDialogo = false },
            onConfirm = { titulo, categoria, duracion, sinopsis, fotoURI ->
                viewModel.agregaPelicula(titulo, categoria, duracion, sinopsis, fotoURI)
                mostrarDialogo = false
            }
        )
    }
}

@Composable
fun PeliculaCard(
    pelicula: Pelicula,
    onDelete: (Int) -> Unit
    ) {
    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column() {
                    if (pelicula.fotoUri != null) {
                        AsyncImage(
                            model = pelicula.fotoUri,
                            contentDescription = "Avatar",
                            modifier = Modifier.size(48.dp)
                        )
                    }else{
                        Image(
                            painter = painterResource(pelicula.foto),
                            contentDescription = "Avatar",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                    Text(text = pelicula.titulo)
                    Text(text = pelicula.categoria)
                    Text(text = pelicula.duracion)
                    Text(text = pelicula.sinopsis)
                }

                IconButton(
                    onClick = {
                        onDelete(pelicula.id)
                    },
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        modifier = Modifier.size(48.dp),

                    )
                }
            }

        }
    }
}

@Composable
fun AgregarPeliculaDialog(
    onDismiss: () -> Unit,
    onConfirm: (String, String, String, String, String) -> Unit
){
    var titulo by remember { mutableStateOf("") }
    var categoria by remember { mutableStateOf("") }
    var duracion by remember { mutableStateOf("") }
    var sinopsis by remember { mutableStateOf("") }
    var foto by remember {mutableStateOf<Uri?>(null)}

    var launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        foto = uri
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {Text("Nuevo Usuario")},
        text = {
            Column {

                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                        .clickable{
                            launcher.launch("image/*")
                        }
                ){
                    if (foto != null){
                        AsyncImage(
                            model = foto,
                            contentDescription = "Avatar",
                            modifier = Modifier.fillMaxSize().clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }else{
                        Icon(
                            imageVector = Icons.Default.AccountBox,
                            contentDescription = "Avatar",
                            modifier = Modifier.size(48.dp)
                        )
                    }
                }

                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it},
                    label = { Text("Titulo") },
                    singleLine = true
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = categoria,
                    onValueChange = { categoria = it },
                    label = { Text("Categoria") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = duracion,
                    onValueChange = { duracion = it },
                    label = { Text("Duracion") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = sinopsis,
                    onValueChange = { sinopsis = it },
                    label = { Text("Sinopsis") },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirm(titulo, categoria, duracion, sinopsis, foto.toString())
                }
            ) {
                Text("Agregar")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancelar")
            }
        }


    )
}