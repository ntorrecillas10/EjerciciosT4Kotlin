package com.example.kotlint4herenciaclases

class Triangulo(val lado1: Double, val lado2: Double, val lado3: Double) {
    val perimetro: Double
        get() = lado1 + lado2 + lado3

    val tipo: String
        get() = when {
            lado1 == lado2 && lado2 == lado3 -> "Equilatero"
            lado1 == lado2 || lado2 == lado3 || lado1 == lado3 -> "Isosceles"
            else -> "Escaleno"
        }

    fun rectangulo(): Boolean {
        val lados = listOf(lado1, lado2, lado3).sorted()
        return (lados[0] * lados[0] + lados[1] * lados[1]) == lados[2] * lados[2]
    }
}

fun main() {
    val triangulo1 = Triangulo(3.0, 4.0, 5.0)
    println("Perimetro: ${triangulo1.perimetro}")
    println("Tipo: ${triangulo1.tipo}")
    println("Es rectangulo? ${triangulo1.rectangulo()}")

    val triangulo2 = Triangulo(2.0, 2.0, 2.0)
    println("Perimetro: ${triangulo2.perimetro}")
    println("Tipo: ${triangulo2.tipo}")
    println("Es rectangulo? ${triangulo2.rectangulo()}")
}