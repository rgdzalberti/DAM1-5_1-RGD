package noInterface
import kotlin.random.Random

 open class ArmaDeFuego(nombre: String, municion:Int, municionARestar:Int, tipoDeMunicion:String, danio:Int, radio:String){

    private val nombre = nombre
    protected var municion = municion
        set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    protected var municionARestar = municionARestar
        set (value) = if (value>=0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    private val tipoDeMunicion = tipoDeMunicion
    private var danio = danio
    private val radio = radio

    init { require(radio.lowercase() == "pequeño" || radio.lowercase() == "amplio"){"La variable radio solo puede ser \"Pequeño\" o \"Amplio\""} }

    override fun toString(): String {
        return "Esta $nombre tiene $municion de municion, $municionARestar de municion restada, ${tipoDeMunicion.lowercase()} es su tipo de munición, $danio de daño y tiene un alcance ${radio.lowercase()}"
    }

    open fun dispara(disparos: Int){municionARestar += disparos; municion -= municionARestar; municionARestar = 0;}
    fun recarga(municion: Int) {this.municion += municion}

}

class Pistola(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar,tipoDeMunicion,danio, radio)
{
    override fun dispara(disparos: Int){municionARestar = 0; municionARestar += disparos * 1; municion -= municionARestar}
}
class Rifle(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar,tipoDeMunicion,danio, radio)
{
    override fun dispara(disparos: Int){municionARestar = 0;municionARestar += disparos * 2; municion -= municionARestar}
}
class Bazooka(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): ArmaDeFuego (nombre,municion,municionARestar,tipoDeMunicion,danio, radio)
{
    override fun dispara(disparos: Int){municionARestar = 0;municionARestar += disparos * 3; municion -= municionARestar}
}

fun main() {

    val Thompson = Pistola("Thompson",25,0,"Pistola",5,"Pequeño")
    val Bolt = Rifle("Bolt",15,0,"Ligera",60,"Amplio")
    val Colt45 = Bazooka("Colt45",13,0,"Pistola",8,"Pequeño")

    val listaArmas = mutableMapOf<Int,ArmaDeFuego>()

    var i = 0
    while(i != 6){
        when (Random.nextInt(1,4)){
            1 -> listaArmas[i] = Thompson
            2 -> listaArmas[i] = Bolt
            3 -> listaArmas[i] = Colt45
        }
        i++
    }
    for (i in 0 until 6){listaArmas[i]?.dispara(1);println(listaArmas[i])}
}
