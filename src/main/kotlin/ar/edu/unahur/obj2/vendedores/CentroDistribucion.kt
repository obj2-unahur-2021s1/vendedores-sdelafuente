package ar.edu.unahur.obj2.vendedores

class CentroDistribucion(val ciudad: Ciudad, var vendedores: MutableList<Vendedor>) {
    fun getEstrella() = vendedores.maxBy { it.puntajeCertificaciones() }
}