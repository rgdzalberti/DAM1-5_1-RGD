import kotlin.random.Random

open class ArmaDeFuego(nombre: String, municion:Int, municionARestar:Int, tipoDeMunicion:String, danio:Int, radio:String){

    private val nombre = nombre
    private var municion = municion
        set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    private var municionARestar = municionARestar
        set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    private val tipoDeMunicion = tipoDeMunicion
    private var danio = danio
    private val radio = radio

    init { require(radio.lowercase() == "pequeño" || radio.lowercase() == "amplio"){"La variable radio solo puede ser \"Pequeño\" o \"Amplio\""} }

    override fun toString(): String {
        return "Esta $nombre tiene $municion de municion, $municionARestar de municion a restar, ${tipoDeMunicion.lowercase()} es su tipo de munición, $danio de daño y tiene un alcance ${radio.lowercase()}"
    }

    fun dispara(){municionARestar++}
    fun recarga(municion: Int) {this.municion = municion}

    class Pistola(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar * 1,tipoDeMunicion,danio, radio)
    {

    }
    class Rifle(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar * 2,tipoDeMunicion,danio, radio)
    {

    }
    class Bazooka(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar * 3,tipoDeMunicion,danio, radio)
    {
    }

}

fun main() {

    val Thompson = ArmaDeFuego.Pistola("Thompson",25,1,"Pistola",5,"Pequeño")
    val Bolt = ArmaDeFuego.Rifle("Bolt",5,1,"Ligera",60,"Amplio")
    val Colt45 = ArmaDeFuego.Bazooka("Colt45",13,1,"Pistola",8,"Pequeño")

    val listaArmas = mutableMapOf<Int,ArmaDeFuego>()

    var i = 0
    while(i != 6){

        when (Random.nextInt(1,3)){
            1 -> listaArmas[i] = Thompson
            2 -> listaArmas[i] = Bolt
            3 -> listaArmas[i] = Colt45
        }

        i++
    }

    for (i in 0 until 6){listaArmas[i]?.dispara();println(listaArmas[i])}





}
