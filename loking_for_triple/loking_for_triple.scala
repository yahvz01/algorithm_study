def isTriple( first : Int )( second : Int )( third : Int ) = {
    val sum = first + second + third
    if( sum == 0 ) true else false
}


def solution(number: Vector[Int]): Int = {
    var combination = 0
    
    for first <- 0 until ( number.size - 2)
    do 
        for second <- (first + 1) until (n umber.size - 1)
        do
            for third <- (second + 1) until ( number.size )
            do
                if(checkWithFirstSecond(number(third))) {
                    combination += 1
             
    return combination
}

@main
def main() = {
    println("hello")

    println( solution(Vector(-2, 3, 0, 2, -5)) )
    println( solution(Vector(-3, -2, -1, 0, 1, 2, 3)) )
    println( solution(Vector(-1, 1, 1, 1)) )
}