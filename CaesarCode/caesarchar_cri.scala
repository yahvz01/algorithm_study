object CaesarChar {
    def isSpace( data : Int) : Boolean =
        (data == 32)

    def isUpperCase( data : Int) : Boolean =
        if(data >= 65 && data <= 90) true
        else false

    def isLowerCase( data : Int) : Boolean =
        if(data >= 97 && data <= 122) true
        else false

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
    def converted( param : Int ) : Int = {
        var preconverted = ((originData + param) % 91)
        if(preconverted < 65)
            preconverted + 65
        else
            preconverted
    }
}
case class Lower( originData : Int ) extends CaesarChar {
    def converted( param : Int ) : Int = {
        var preconverted = ((originData + param) % 123)
        if(preconverted < 97)
            preconverted + 97
        else
            preconverted
    }
}
case class Space( originData : Int ) extends CaesarChar {
    def converted( param : Int ) : Int = originData
}


object Solution {
    def solution(s: String, n: Int): String = {
        return s.split("")
            .map( data => CaesarChar(data.charAt(0).toInt) )
            .map( _.converted(n) )
            .map( _.toChar ).foldLeft("")( _ + _ )
    }
}
