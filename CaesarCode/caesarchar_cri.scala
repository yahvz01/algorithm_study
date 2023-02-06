object CaesarChar {

    def isUpperCase( data : Int) : Boolean =
        if( 65 to 90 contains data ) true
        else false

    def isLowerCase( data : Int) : Boolean =
        if( 97 to 122 contains data ) true
        else false

    def isSpace( data : Int) : Boolean =
        (data == 32)

    def apply( originData : Int ) : CaesarChar =
        originData match {
            case data if isUpperCase(data) => Upper(originData)
            case data if isLowerCase(data) => Lower(originData)
            case _ => Space(originData)
        }
}

sealed abstract class CaesarChar {
    def converted( param : Int ) : Int
}

case class Upper( originData : Int ) extends CaesarChar {
    def this( originData : Char ) = this(originData.toInt)
    def converted( param : Int ) : Int = {
        var preconverted = ((originData + param) % 91)
        if(preconverted < 65)
            preconverted + 65
        else
            preconverted
    }
}
case class Lower( originData : Int ) extends CaesarChar {
    def this( originData : Char ) = this(originData.toInt)
    def converted( param : Int ) : Int = {
        var preconverted = ((originData + param) % 123)
        if(preconverted < 97)
            preconverted + 97
        else
            preconverted
    }
}
case class Space( originData : Int ) extends CaesarChar {
    def this( originData : Char ) = this(originData.toInt)
    def converted( param : Int ) : Int = originData
}


object Solution {
    def solution(s: String, n: Int): String = {
        return s.split("")
            .map( CaesarChar( _.charAt(0)) )
            .map( _.converted(n) )
            .map( _.toChar ).foldLeft("")( _ + _ )
    }
}
