package ar.edu.unahur.obj2.caralibro

import java.lang.Exception

class Usuario {
  val publicaciones = mutableListOf<Publicacion>()
  val amigos = mutableListOf<Usuario>()


  fun agregarPublicacion(publicacion: Publicacion) {
    publicaciones.add(publicacion)
  }

  fun agregarAmigo(amigo: Usuario) {amigos.add(amigo)}

  fun cantidadAmigos() = amigos.size

  fun espacioDePublicaciones() = publicaciones.sumBy { it.espacioQueOcupa() }

  fun esMasAmistoso_Que_(unUsuario: Usuario, otroUsuario: Usuario) {
    unUsuario.amigos.size > otroUsuario.amigos.size
  }

  fun mejoresAmigos() = amigos.filter { a -> this.puedenVerTodasLasPublicaciones(a) }

  fun puedenVerTodasLasPublicaciones(usuario: Usuario) = publicaciones.all { p -> p.puedeVerPublicacion(usuario) }

  fun amigoMasPopular() = amigos.maxByOrNull { a -> a.cantidadDeMegustaTotal() }

  fun cantidadDeMegustaTotal() = publicaciones.sumBy { it.cantidadMeGusta() }

  fun esStalker(usuario: Usuario) = (this.cantidadDePublicacionesQue_DioMegusta(usuario) * 100) / this.publicaciones.size > 90

  fun cantidadDePublicacionesQue_DioMegusta(usuario: Usuario) = publicaciones.filter { p -> p.leDioMeGusta(usuario) }.size
}
