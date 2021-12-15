package Interface
import kotlin.random.Random

 open interface Interfaz{

    var municion:Int
    var municionARestar:Int

    open fun dispara(disparos: Int){municionARestar = 0;municionARestar += disparos * 2; municion -= municionARestar}
    fun recarga(municion: Int) {this.municion += municion}

}

 open class ArmaDeFuego(nombre: String, municion:Int, municionARestar:Int, tipoDeMunicion:String, danio:Int, radio:String):Interfaz{

    private val nombre = nombre
    override var municion = municion
        set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    override var municionARestar = municionARestar
        set (value) = if (value>=0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    private val tipoDeMunicion = tipoDeMunicion
    private var danio = danio
    private val radio = radio

    init { require(radio.lowercase() == "pequeño" || radio.lowercase() == "amplio"){"La variable radio solo puede ser \"Pequeño\" o \"Amplio\""} }

    override fun toString(): String {
        return "Esta $nombre tiene $municion de municion, $municionARestar de municion restada, ${tipoDeMunicion.lowercase()} es su tipo de munición, $danio de daño y tiene un alcance ${radio.lowercase()}"
    }

    open override fun dispara(disparos: Int){municionARestar = 0;municionARestar += disparos * 2; municion -= municionARestar}
    override fun recarga(municion: Int) {this.municion += municion}

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

}

 class Bocadillo(nombre: String,municion:Int,municionARestar:Int,tipoDeMunicion:String, danio:Int,radio:String): Interfaz
{
    private val nombre = nombre
    override var municion = municion
        set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    override var municionARestar = municionARestar
        set (value) = if (value>=0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    private val tipoDeMunicion = tipoDeMunicion
    private var danio = danio
    private val radio = radio

    override fun toString(): String {
        return "Felicidades, tu $nombre tiene $municion balas , $municionARestar de municion restada, ${tipoDeMunicion.lowercase()} es su tipo de munición, $danio de daño y tiene un alcance ${radio.lowercase()}"
    }

   override fun dispara(disparos: Int){municionARestar = 0;municionARestar += disparos * 2; municion -= municionARestar}
}

class Cajón(nombre: String,municion:Int,municionARestar:Int): Interfaz
{
    private val nombre = nombre
    override var municion = municion
        set (value) = if (value>0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")
    override var municionARestar = municionARestar
        set (value) = if (value>=0) {field = value} else throw IllegalArgumentException("El valor no puede ser menor de 0")

    override fun toString(): String {
        return "No me preguntes como, pero tu cajón $nombre ha disparado y tiene $municion balas restantes así como se le han restado $municionARestar balas"
    }

    override fun dispara(disparos: Int){municionARestar = 0;municionARestar += disparos * 2; municion -= municionARestar}
}

fun main() {

    //Desmuestro que mi Bocadillo es capaz de disparar y lo introduzco en el algoritmo del 5_1 como si fuese una opción más
    val Bocadillo = Bocadillo("Bocadillo de Jamón",30,0,"Fuet",600,"amplio")
    Bocadillo.dispara(1)
    println(Bocadillo)
    val Cajon = Cajón("de madera de alcornoque",52,0)

    val Thompson = ArmaDeFuego.Pistola("Thompson",25,0,"Pistola",5,"Pequeño")
    val Bolt = ArmaDeFuego.Rifle("Bolt",15,0,"Ligera",60,"Amplio")
    val Colt45 = ArmaDeFuego.Bazooka("Colt45",13,0,"Pistola",8,"Pequeño")

    val listaArmas = mutableMapOf<Int,Interfaz>()

    var i = 0
    while(i != 6){
        when (Random.nextInt(1,6)){
            1 -> listaArmas[i] = Thompson
            2 -> listaArmas[i] = Bolt
            3 -> listaArmas[i] = Colt45
            4 -> listaArmas[i] = Bocadillo
            5 -> listaArmas[i] = Cajon
        }
        i++
    }
    for (i in 0 until 6){listaArmas[i]?.dispara(1);println(listaArmas[i])}

}
