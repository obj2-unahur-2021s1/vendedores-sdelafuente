package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeEven
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import javax.xml.stream.events.ProcessingInstruction

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
    val cert1 = Certificacion(true,20)
    val cert2 = Certificacion(true,5)
    val cert3 = Certificacion(false,10)

    val centroDistribucion = CentroDistribucion(cosquin, mutableListOf())

    val viajante = Viajante(listOf(misiones, cordoba, neuquen))

    describe("Centro Distribucion") {
        describe("agrego vendedor") {
            centroDistribucion.vendedores.add(viajante)
            it("Se agregó el vendedor") {
                centroDistribucion.vendedores.size.shouldBeExactly(1)
            }
        }
    }
})
