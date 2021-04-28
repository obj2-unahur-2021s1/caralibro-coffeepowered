package ar.edu.unahur.obj2.caralibro

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class UsuarioTest : DescribeSpec({
  describe("Caralibro") {
    val saludoCumpleanios = Texto("Felicidades Pepito, que los cumplas muy feliz")
    val fotoEnCuzco = Foto(768, 1024)
    val fotoGato = Foto(600, 800)
    //val videoPublicado = Video(120)
    val videoSD = Video( 60 , "SD")
    val video720 = Video(60 , "720p")
    val video1080 = Video(60 , "1080p")

    describe("Una publicación") {
      describe("de tipo foto") {
        it("ocupa ancho * alto * compresion bytes") {
          fotoEnCuzco.espacioQueOcupa().shouldBe(550503)
        }
      }

      describe("de tipo texto") {
        it("ocupa tantos bytes como su longitud") {
          saludoCumpleanios.espacioQueOcupa().shouldBe(45)

        }
      }
      describe("de tipo video") {
        it("depende de la calidad del video") {
           //videoPublicado.espacioQueOcupa().shouldBe(120)
           videoSD.espacioQueOcupa().shouldBe(60)
           video720.espacioQueOcupa().shouldBe(180)
           video1080.espacioQueOcupa().shouldBe(360)
        }
      }
    }

    describe("Un usuario") {
      it("puede calcular el espacio que ocupan sus publicaciones") {
        val juana = Usuario()
        juana.agregarPublicacion(fotoEnCuzco)
        juana.agregarPublicacion(saludoCumpleanios)
        juana.espacioDePublicaciones().shouldBe(550548)
      }


        describe("otro usuario") {
          it("puede dar me gusta a una publicacion") {
            val raul = Usuario()
            val matias = Usuario()
            matias.agregarPublicacion(fotoGato)
            matias.agregarAmigo(raul)
            fotoGato.recibirMegustaDe_(raul)
            fotoGato.cantidadMeGusta().shouldBe(1)

            raul.agregarAmigo(matias)
            raul.cantidadAmigos().shouldBe(1)
            matias.cantidadAmigos().shouldBe(1)
          }

      }
    }
  }
})
