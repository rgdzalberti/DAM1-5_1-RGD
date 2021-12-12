package un1.eje5_1

data class Ingrediente(val nombre: String, val cantidad: Double, val unidad: String)
data class Receta(val nombre: String, val ingredientes: Set<Ingrediente>, val pasos: Map<Int, String>)

 class ArmaDeFuego(var nombre: String,var municion:Int,var municionARestar:Int,var tipoDeMunicion:String,var danio:Int,radio:String){
    init {if (radio.lowercase() != "pequeño" || radio.lowercase() != "amplio") {println("ERROR: Solo puedes introducir los valores Pequeño o Amplio para la variable radio")} }

    fun dispara(municionARestar: Int){municionARestar++}
    fun recarga(municion: Int) {municion++}

}


fun main() {
    var unaReceta = Receta(
        "Arrzo con Leche",
        setOf(
            Ingrediente("Arroz", 1000.0, "gr"),
            Ingrediente("Leche", 1.0, "l"),
            Ingrediente("Canela en rama", 1.0, "palo")
        ),
        mapOf(
            1 to "Calentar la leche",
            2 to "Echar el arroz",
            3 to "Remover frecuentemente",
            4 to "Apagar el fuego cuando el arroz este blandito con el corazon duro"
        )
    )
    println("$unaReceta")

}