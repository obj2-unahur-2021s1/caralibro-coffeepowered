package ar.edu.unahur.obj2.caralibro

import java.lang.Exception

class Usuario {
  val publicaciones = mutableListOf<Publicacion>()
  val amigos = mutableListOf<Usuario>()


  fun agregarPublicacion(publicacion: Publicacion) {
    publicaciones.add(publicacion)
  }

  fun espacioDePublicaciones() = publicaciones.sumBy { it.espacioQueOcupa() }

  fun esMasAmistoso_Que_(unUsuario: Usuario, otroUsuario: Usuario) {
    unUsuario.amigos.size > otroUsuario.amigos.size
  }

  fun mejoresAmigos() = amigos.filter { a -> this.puedenVerTodasLasPublicaciones(a) }

  fun puedenVerTodasLasPublicaciones(usuario: Usuario) = publicaciones.all { p -> p.puedeVerPublicacion(usuario) }

  fun amigoMasPopular() = amigos.maxByOrNull { a -> a.cantidadDeMegustaTotal() }

  fun cantidadDeMegustaTotal() = publicaciones.sumBy { it.cantidadMeGusta() }
}
