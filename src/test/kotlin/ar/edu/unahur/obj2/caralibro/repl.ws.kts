package ar.edu.unahur.obj2.caralibro

// Pueden usar este archivo para hacer pruebas rápidas,
// de la misma forma en que usaban el REPL de Wollok.

// OJO: lo que esté aquí no será tenido en cuenta
// en la corrección ni reemplaza a los tests.

listOf(1, 8, 10).average()

"todo junto".length
"todojunto".length
abstract class Publicacion {
    abstract fun espacioQueOcupa(): Int
}
class Video (val segundos: Int, var calidadDeVideo: Int) : Publicacion(){
    //var calidadDeVideo: Int = videoSD
    val videoSD = 1
    val video720p = 3
    val video1080p = 6
    override fun espacioQueOcupa() = segundos * calidadDeVideo
    fun cambiarCalidadDelVideo(calidad: Int) {
        calidadDeVideo = calidad
    }
}

val videoGracioso = Video(120, 1)
videoGracioso.espacioQueOcupa()
videoGracioso.cambiarCalidadDelVideo(2)
videoGracioso.espacioQueOcupa()
