package ar.edu.unahur.obj2.caralibro

import kotlin.math.ceil

class MeGusta (val gustoPublicacion: Boolean)

abstract class Publicacion {

  abstract fun espacioQueOcupa(): Int

  val meGustas = mutableListOf<MeGusta>()

  fun cantidadDeMegustas() = meGustas.size

  fun leDioMegusta(usuario: Usuario) = meGustas.contains(usuario)
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

