package ar.edu.unahur.obj2.caralibro

import kotlin.math.ceil

abstract class Publicacion {
    abstract fun espacioQueOcupa(): Int

    val meGustaRecibidos = mutableListOf<Usuario>()
    fun cantidadMeGusta(): Int { return meGustaRecibidos.size }
    fun usuariosQueDieronMeGusta() = meGustaRecibidos

    fun leDioMeGusta(usuario: Usuario) = meGustaRecibidos.contains(usuario)

    //permisos posibles: publico, soloAmigos, privadoConPermitidos, publicoConExcluidos
    var permisoVisibilidad =  "publico" //iniciado por defecto en publico

    //para publicaciones privadas con permitidos
    val permitidos = mutableListOf<Usuario>()

    //para publicaciones publicas con excluidos
    val excluidos = mutableListOf<Usuario>()

    val amigos = mutableListOf<Usuario>()

    //lo usuarios le pueden dar me gusta a una publicacion, se tiene que saber
    // que usuario dio me gusta y un usuario solo dar me gusta 1 vez.
    fun recibirMegustaDe_(usuarioActual: Usuario)
    {  //si usuarioActual no dio me gusta aun, lo agrego a la lista de me gusta
        if (puedeVerPublicacion(usuarioActual) && usuarioActual !in meGustaRecibidos)
        {
            meGustaRecibidos.add(usuarioActual)
        }
        else //si ya dio me gusta, lo notifico
        {
            error("Un usuario no puede dar Me gusta mas de una vez.")
        }
    }
    //por defecto una publicacion es publica, pero aca se puede cambiar eso
    //permisos posibles: publico, soloAmigos, privadoConPermitidos, publicoConExcluidos
    fun cambiarPermisoVisibilidadA_(nuevoPermiso: String)
    {
        permisoVisibilidad = nuevoPermiso
    }

    //indica si un usuario puede ver la publicacion
    var puedeVer = false
    fun puedeVerPublicacion(usuarioActual: Usuario): Boolean {
        if (permisoVisibilidad == "publico"){
            puedeVer = true
        }
        if (permisoVisibilidad == "soloAmigos" && amigos.contains(usuarioActual)){
             puedeVer = true
        }
        if (permisoVisibilidad == "privadoConPermitidos" && permitidos.contains(usuarioActual)){
            puedeVer = true
        }
        if (permisoVisibilidad == "publicoConExcluidos" && excluidos.contains(usuarioActual) ){
             puedeVer = false
        } //estoy casi seguro de que hay una forma mas breve de escribir esto pero no se me ocurre ahora
        return puedeVer
    }
}

class Foto(val alto: Int, val ancho: Int) : Publicacion() {
    val factorDeCompresion = 0.7
    override fun espacioQueOcupa() = ceil(alto * ancho * factorDeCompresion).toInt()
}

class Texto(val contenido: String) : Publicacion() {
    override fun espacioQueOcupa() = contenido.length
}

class Video (val segundos: Int, val calidadDeVideo: String ) : Publicacion(){
    //var calidadDeVideo: String = "SD"

    //Espacio que ocupa video en bytes dependiendo de la calidad del video
    override fun espacioQueOcupa(): Int {
        var espacioDelVideoActual : Int =segundos

        if (calidadDeVideo == "SD") { espacioDelVideoActual = segundos * 1}
        if (calidadDeVideo == "720p") { espacioDelVideoActual = segundos * 3}
        if (calidadDeVideo == "1080p") {espacioDelVideoActual = segundos * 6}
        return espacioDelVideoActual
    }

    //cambia la calidad del video
    //fun cambiarCalidadDelVideo(calidad: String) {
    //    calidadDeVideo = calidad }

}