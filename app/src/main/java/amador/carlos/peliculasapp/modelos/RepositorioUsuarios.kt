package amador.carlos.peliculasapp.modelos

class RepositorioUsuarios {

    fun getUsuarios(): List<Usuario> {
        return listOf(
            Usuario(1,"Carlos", "carlos@gmail.com", 20),
            Usuario(2,"Kirby", "kirbyTragon@gmail.com", 70),
            Usuario(3, "Pasita", "lilRaisin@gmail.com", 20)
        )
    }

}