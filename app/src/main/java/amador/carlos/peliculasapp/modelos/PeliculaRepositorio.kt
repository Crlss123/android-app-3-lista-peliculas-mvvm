package amador.carlos.peliculasapp.modelos

class PeliculaRepositorio {

    fun getPeliculas(): List<Pelicula> {
        return listOf(
            Pelicula(0,"Die Hard", "Accion", "1h 30m","Pelon en edificio en navidad"),
            Pelicula(1, "KPOP Demon Hunters", "CINEMA", "1h 30m", "Mujeres aura farmean")
        )
    }

}