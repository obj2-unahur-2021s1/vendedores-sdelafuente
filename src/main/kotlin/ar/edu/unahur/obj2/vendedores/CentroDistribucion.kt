package ar.edu.unahur.obj2.vendedores

class CentroDistribucion(
    val ciudad: Ciudad
) {
    val vendedores = mutableListOf<Vendedor>()

    fun obtenerVendedorEstrella() = vendedores.maxBy { it.puntajeCertificaciones() }

    fun agregarVendedor(v: Vendedor) {
        vendedores.find { it == v }?.let {
            throw Exception("Vendedor ya existente!")
        }
        vendedores.add(v)
    }
}