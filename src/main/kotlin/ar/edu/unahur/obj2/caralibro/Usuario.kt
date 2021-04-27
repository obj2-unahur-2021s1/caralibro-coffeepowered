package ar.edu.unahur.obj2.caralibro

import java.lang.Exception

class Usuario {
  val publicaciones = mutableListOf<Publicacion>()
  val amigos = mutableListOf<Usuario>()

  fun agregarPublicacion(publicacion: Publicacion) {
    publicaciones.add(publicacion)
  }

  fun espacioDePublicaciones() = publicaciones.sumBy { it.espacioQueOcupa() }

  //fun darMegusta(publicacion: Publicacion){
  //  if (this.leDioMegusta(publicacion)){
  //    throw Exception("ya le dio me gusta a la publicacion")
  //  }
  //  publicacion.meGustas.add()
  //}
}
