package ar.edu.unahur.obj2.caralibro

import kotlin.math.ceil

abstract class Publicacion {
  abstract fun espacioQueOcupa(): Int
}

class Foto(val alto: Int, val ancho: Int) : Publicacion() {
  val factorDeCompresion = 0.7
  override fun espacioQueOcupa() = ceil(alto * ancho * factorDeCompresion).toInt()
}

class Texto(val contenido: String) : Publicacion() {
  override fun espacioQueOcupa() = contenido.length
}

class Video (val segundos: Int, var calidadDeVideo: Int) : Publicacion(){
  val videoSD = 1
  val video720p = 3
  val video1080p = 6
  override fun espacioQueOcupa() = segundos * calidadDeVideo

}
