package amador.carlos.peliculasapp

import amador.carlos.peliculasapp.modelos.PeliculaRepositorio
import amador.carlos.peliculasapp.modelos.RepositorioUsuarios
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import amador.carlos.peliculasapp.ui.theme.PeliculasAppTheme
import amador.carlos.peliculasapp.viewmodels.PeliculasViewModel
import amador.carlos.peliculasapp.viewmodels.PeliculasViewModelFactory
import amador.carlos.peliculasapp.viewmodels.UsuarioViewModel
import amador.carlos.peliculasapp.viewmodels.UsuarioViewModelFactory
import amador.carlos.peliculasapp.vistas.PeliculasScreen
import amador.carlos.peliculasapp.vistas.UsuarioScreen
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    private val TAG = "PELICULAS"

    private val viewModel: PeliculasViewModel by viewModels {
        PeliculasViewModelFactory(PeliculaRepositorio())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Log.d(TAG, "Create")

        setContent {
//            PeliculasAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }

            PeliculasScreen(viewModel)

        }
    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Start")
    }

    override fun onResume(){
        super.onResume()
        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Resume")
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Stop")
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Pause")
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Restart", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "Restart")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
