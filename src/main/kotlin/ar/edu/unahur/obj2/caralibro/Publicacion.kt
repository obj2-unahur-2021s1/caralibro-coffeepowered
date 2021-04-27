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

class Video (val segundos: Int) : Publicacion(){
  var calidadDeVideo: String = "SD"

  //Espacio que ocupa video en bytes dependiendo de la calidad del video
  override fun espacioQueOcupa(): Int {
    var espacioDelVideoActual : Int =segundos

    if (calidadDeVideo == "SD") { espacioDelVideoActual = segundos * 1}
    if (calidadDeVideo == "720p") { espacioDelVideoActual = segundos * 3}
    if (calidadDeVideo == "1080p") {espacioDelVideoActual = segundos * 6}
    return espacioDelVideoActual
  }

  //cambia la calidad del video
  fun cambiarCalidadDelVideo(calidad: String) {
    calidadDeVideo = calidad
  }
}

