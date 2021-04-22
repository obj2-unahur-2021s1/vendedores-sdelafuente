package ar.edu.unahur.obj2.vendedores

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class VendedorTest : DescribeSpec({
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

  //Test
  describe("Vendedor fijo") {
    val obera = Ciudad(misiones)
    val vendedorFijo = VendedorFijo(obera)
    describe("puedeTrabajarEn") {
      it("su ciudad de origen") {
        vendedorFijo.puedeTrabajarEn(obera).shouldBeTrue()
      }
      it("otra ciudad") {
        vendedorFijo.puedeTrabajarEn(sanIgnacio).shouldBeFalse()
      }
      it("un vendedor es influyente") {
        vendedorFijo.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Viajante") {
    val villaDolores = Ciudad(cordoba)
    val viajante = Viajante(listOf(misiones, cordoba, neuquen))

    describe("puedeTrabajarEn") {
      it("una ciudad que pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(sanIgnacio).shouldBeTrue()
      }
      it("una ciudad que pertenece a otra provincia habilitada") {
        viajante.puedeTrabajarEn(zapala).shouldBeTrue()
      }
      it("una ciudad que no pertenece a una provincia habilitada") {
        viajante.puedeTrabajarEn(villaDolores).shouldBeTrue()
      }
      it("un vendedor es influyente") {
        viajante.esInfluyente().shouldBeFalse()
      }
    }
  }

  describe("Comercio corresponsal") {

    val vendedorComercioCorresponsal = ComercioCorresponsal(listOf(cosquin, sanIgnacio, tresArroyos))

    it("tiene una ciudad que posee una sucursal") {
      vendedorComercioCorresponsal.puedeTrabajarEn(cosquin).shouldBeTrue()
    }
    it("tiene una ciudad que no posee una sucursal") {
      vendedorComercioCorresponsal.puedeTrabajarEn(zapala).shouldBeFalse()
    }
    it("es influyente") {
      vendedorComercioCorresponsal.esInfluyente().shouldBeTrue()
    }
  }

  describe("vendedor versatil") {
    val viajante = Viajante(listOf(misiones, cordoba, neuquen))
    viajante.agregarCertificacion(cert1)
    viajante.agregarCertificacion(cert2)
    viajante.agregarCertificacion(cert3)

    it("es versatil") {
      viajante.esVersatil().shouldBeTrue()
    }
  }

  describe("vendedor no versatil") {

    describe("no versatil por cantidad") {
      val viajante = Viajante(listOf(misiones, cordoba, neuquen))
      viajante.agregarCertificacion(cert1)
      viajante.agregarCertificacion(cert2)

      it("no es versatil") {
        viajante.esVersatil().shouldBeFalse()
      }
    }

    describe("no versatil por productos") {
      val viajante = Viajante(listOf(misiones, cordoba, neuquen))
      viajante.agregarCertificacion(cert1)
      viajante.agregarCertificacion(cert1)
      viajante.agregarCertificacion(cert1)

      it("no es versatil") {
        viajante.esVersatil().shouldBeFalse()
      }
    }

    describe("no versatil por no productos") {
      val viajante = Viajante(listOf(misiones, cordoba, neuquen))
      viajante.agregarCertificacion(cert3)
      viajante.agregarCertificacion(cert3)
      viajante.agregarCertificacion(cert3)

      it("no es versatil") {
        viajante.esVersatil().shouldBeFalse()
      }
    }

    describe("Vendedor viajante firme") {
      val vendedorFijo = VendedorFijo(tresArroyos)
      vendedorFijo.agregarCertificacion(cert1)
      vendedorFijo.agregarCertificacion(cert2)
      vendedorFijo.agregarCertificacion(cert3)
      describe("Es firme ") {
        vendedorFijo.esFirme().shouldBeTrue()
      }
    }
  }
})
