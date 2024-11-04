package com.example.kotlint4herenciaclases

data class Contacto(
    val nombre: String,
    val telefono: String,
    val correoElectronico: String
)

class GestorContactos {
    private val contactos = mutableListOf<Contacto>()

    fun agregarContacto(contacto: Contacto) {
        contactos.add(contacto)
        println("Contacto agregado: $contacto")
    }

    fun eliminarContacto(nombre: String) {
        val contactoAEliminar = contactos.find { it.nombre == nombre }
        if (contactoAEliminar != null) {
            contactos.remove(contactoAEliminar)
            println("Contacto eliminado: $contactoAEliminar")
        } else {
            println("Contacto no encontrado.")
        }
    }

    fun mostrarContactos() {
        if (contactos.isEmpty()) {
            println("No hay contactos en la lista.")
        } else {
            println("Lista de Contactos:")
            contactos.forEach { println(it) }
        }
    }
}

fun main() {
    val gestor = GestorContactos()

    gestor.agregarContacto(Contacto("Juan Perez", "555-1234", "juan.perez@email.com"))
    gestor.agregarContacto(Contacto("Maria Lopez", "555-5678", "maria.lopez@email.com"))

    gestor.mostrarContactos()

    //gestor.eliminarContacto("Juan Pérez")

    //gestor.mostrarContactos()
}