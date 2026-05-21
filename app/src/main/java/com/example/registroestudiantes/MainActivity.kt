fun main() {
    val nombreCurso = "Programación Funcional"
    val nombreProfesor = "Profesor Fulano"
    val maximoEstudiantes = 5

    var estudiantes: MutableList<String> = mutableListOf()

    println("Sistema de registro de estudiantes\n")
    println("Ingrese los nombres de $maximoEstudiantes estudiantes:")

    for (i in 1..maximoEstudiantes) {
        print("Estudiante $i: ")
        val nombre = readLine() ?: ""
        if (nombre.isNotEmpty()) {
            estudiantes.add(nombre)
        }
    }

    var calificaciones: MutableMap<String, Double> = mutableMapOf()

    println("\nIngrese las calificaciones de cada estudiante:")
    for (estudiante in estudiantes) {
        print("Calificacion de $estudiante: ")
        val calificacionInput = readLine() ?: "0"
        val calificacion = calificacionInput.toDoubleOrNull() ?: 0.0
        calificaciones[estudiante] = calificacion
    }

    var ciudades: MutableSet<String> = mutableSetOf()

    println("\nIngrese la ciudad de origen de cada estudiante:")
    for (estudiante in estudiantes) {
        print("Ciudad de $estudiante: ")
        val ciudad = readLine() ?: ""
        if (ciudad.isNotEmpty()) {
            ciudades.add(ciudad)
        }
    }

    var aprobados = 0
    var reprobados = 0
    var sumaCalificaciones = 0.0

    println("\nResultados:")
    for (estudiante in estudiantes) {
        val calificacion = calificaciones[estudiante] ?: 0.0
        sumaCalificaciones += calificacion

        val resultado = if (calificacion >= 70) {
            aprobados++
            "Aprobado"
        } else {
            reprobados++
            "Reprobado"
        }

        println("$estudiante - Calificacion: $calificacion - $resultado")
    }

    val promedio = if (estudiantes.isNotEmpty()) sumaCalificaciones / estudiantes.size else 0.0

    println("\nResumen:")
    println("Curso: $nombreCurso")
    println("Profesor: $nombreProfesor")
    println("Total de estudiantes registrados: ${estudiantes.size}")
    println("\nLista de estudiantes:")
    for (estudiante in estudiantes) {
        println("  - $estudiante")
    }
    println("\nCiudades registradas: ${ciudades.size} diferentes")
    for (ciudad in ciudades) {
        println("  - $ciudad")
    }
    println("\nPromedio del grupo: ${"%.2f".format(promedio)}")
    println("Cantidad de estudiantes aprobados: $aprobados")
    println("Cantidad de estudiantes reprobados: $reprobados")
}
