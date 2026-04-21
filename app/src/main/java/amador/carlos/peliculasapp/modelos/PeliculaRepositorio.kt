package amador.carlos.peliculasapp.modelos

import amador.carlos.peliculasapp.R

class PeliculaRepositorio {

    private val peliculas = mutableListOf(
        Pelicula(0,
            "Die Hard",
            "Accion",
            "1h 30m",
            "Pelon en edificio en navidad",
            R.drawable.tabler_movie),
        Pelicula(1,
            "KPOP Demon Hunters",
            "CINEMA",
            "1h 30m",
            "Mujeres aura farmean",
            R.drawable.tabler_movie)
    )

    fun getPeliculas(): List<Pelicula> {
        return peliculas.toList()
    }

    fun agregarPelicula(pelicula: Pelicula) {
        peliculas.add(pelicula)
    }

    fun eliminarPelicula(peliculaID: Int) {
        peliculas.removeAll { it.id == peliculaID }
    }

}