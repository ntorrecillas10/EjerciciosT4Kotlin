package com.example.kotlint4herenciaclases

data class Planeta(
    val nombre: String,
    val tipo: TipoPlaneta,
    val masa: Double
)

enum class TipoPlaneta {
    ROCOSO,
    GASEOSO
}

class SistemaSolar {
    private val planetas = mutableListOf<Planeta>()

    fun agregarPlaneta(planeta: Planeta) {
        planetas.add(planeta)
    }

    fun planetaMayor(): Planeta? {
        return planetas.maxByOrNull { it.masa }
    }

    fun planetaMenor(): Planeta? {
        return planetas.minByOrNull { it.masa }
    }

    fun masaMedia(): Double {
        return if (planetas.isNotEmpty()) {
            planetas.sumOf { it.masa } / planetas.size
        } else {
            0.0
        }
    }
}

fun main() {
    val sistemaSolar = SistemaSolar()

    sistemaSolar.agregarPlaneta(Planeta("Tierra", TipoPlaneta.ROCOSO, 3244.1))
    sistemaSolar.agregarPlaneta(Planeta("Jupiter", TipoPlaneta.GASEOSO, 82933.021))
    sistemaSolar.agregarPlaneta(Planeta("Marte", TipoPlaneta.ROCOSO, 1000.0))

    val planetaMayor = sistemaSolar.planetaMayor()
    val planetaMenor = sistemaSolar.planetaMenor()
    val masaMedia = sistemaSolar.masaMedia()

    println("Planeta de mayor masa: ${planetaMayor?.nombre} con masa ${planetaMayor?.masa} kg")
    println("Planeta de menor masa: ${planetaMenor?.nombre} con masa ${planetaMenor?.masa} kg")
    println("Masa media de los planetas: $masaMedia kg")
}