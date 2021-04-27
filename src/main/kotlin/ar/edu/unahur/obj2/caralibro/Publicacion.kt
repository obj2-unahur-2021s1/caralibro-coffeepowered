package ar.edu.unahur.obj2.caralibro

import kotlin.math.ceil

abstract class Publicacion {
  abstract fun espacioQueOcupa(): Int

  val meGustaRecibidos = mutableListOf<Usuario>()
  fun cantidadMeGusta(): Int { return meGustaRecibidos.size }

  //permisos posibles: publico, soloAmigos, privadoConPermitidos, publicoConExcluidos
  var permisoVisibilidad =  "publico" //iniciado por defecto en publico

  //para publicaciones privadas con permitidos
  val permitidos = mutableListOf<Usuario>()

  //para publicaciones publicas con excluidos
  val excluidos = mutableListOf<Usuario>()

  //lo usuarios le pueden dar me gusta a una publicacion, se tiene que saber
  // que usuario dio me gusta y un usuario solo dar me gusta 1 vez.
  fun recibirMegustaDe_(usuarioActual: Usuario)
  {  //si usuarioActual no dio me gusta aun, lo agrego a la lista de me gusta
    if (usuarioActual !in meGustaRecibidos)
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

}

class Foto(val alto: Int, val ancho: Int) : Publicacion() {
  val factorDeCompresion = 0.7
  override fun espacioQueOcupa() = ceil(alto * ancho * factorDeCompresion).toInt()
}

class Texto(val contenido: String) : Publicacion() {
  override fun espacioQueOcupa() = contenido.length
}

class Video (val segundos: Int, var calidadDeVideo: Int) : Publicacion(){
  //var calidadDeVideo: Int = videoSD
  //val videoSD: Int = 1
  //val video720p: Int = 3
  //val video1080p: Int = 6
  override fun espacioQueOcupa() = segundos * calidadDeVideo
  fun cambiarCalidadDelVideo(calidad: Int) {
    calidadDeVideo = calidad
  }
}

