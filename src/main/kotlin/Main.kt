
open class ArmaDeFuego(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String){
     private val nombre = nombre
     private var municion = municion
     set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
     private var municionARestar = municionARestar
     set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
     private val tipoDeMunicion = tipoDeMunicion
     private var danio = danio
     private val radio = radio

    init { require(radio.lowercase() == "pequeño" || radio.lowercase() == "amplio"){"La variable radio solo puede ser \"Pequeño\" o \"Amplio\""} }

    fun dispara(){municionARestar++}
    fun recarga(municion: Int) {this.municion = municion}

    class Pistola(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar,tipoDeMunicion,danio, radio)
    {
        private var municionARestar = municionARestar * 1
    }
    class Rifle(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar,tipoDeMunicion,danio, radio)
    {
        private var municionARestar = municionARestar * 2
    }
    class Bazooka(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar,tipoDeMunicion,danio, radio)
    {
        private var municionARestar = municionARestar * 3
    }

}


fun main() {


}