package ar.edu.unahur.obj2.vendedores

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec

class CentroDistribucionTest : DescribeSpec({
    //Provincias
    val misiones = Provincia(1300000)
    val neuquen = Provincia(4000000)
    val cordoba = Provincia(4000000)
    val buenosAires = Provincia(12000000)
    val zapala = Ciudad(neuquen)

    //Ciudades
    val sanIgnacio = Ciudad(misiones)
    val cosquin = Ciudad(cordoba)
    val tresArroyos = Ciudad(buenosAires)

    //Certificaciones
    val cert1 = Certificacion(true, 20)
    val cert2 = Certificacion(true, 5)
    val cert3 = Certificacion(false, 10)

    val viajante = Viajante(listOf(misiones, cordoba, neuquen))
    val centroDistribucion = CentroDistribucion(cosquin)


    describe("Centro Distribucion") {
//        describe("agrego vendedor") {
//            centroDistribucion.agregarVendedor(viajante)
//            it("Se agregó el vendedor") {
//                centroDistribucion.size.shouldBeExactly(1)
//            }
//        }

        describe("error al duplicar vendedor") {
            centroDistribucion.agregarVendedor(viajante)

            shouldThrow<Exception> {
                centroDistribucion.agregarVendedor(viajante)
            }
        }
    }
})