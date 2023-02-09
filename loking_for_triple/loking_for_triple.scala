def isTriple( first : Int )( second : Int )( third : Int ) = {
    val sum = first + second + third
    if( sum == 0 ) true else false
}

// using curring function for optimization in scala 3
def solution(number: Vector[Int]): Int = {
    var combination = 0
    for first <- 0 until ( number.size - 2)
    do 
        for second <- (first + 1) until (n umber.size - 1)
        do
            for third <- (second + 1) until ( number.size )
            do
                if  isTriple(number(first), number(second), number(third))
                then combination += 1
    return combination
}

// for scala 2 compiler in programmers
// def solution(number: Vector[Int]): Int = {
//     var combination = 0
    
//     for ( first <- 0 until ( number.size - 2) ) {
//         for ( second <- (first + 1) until (n umber.size - 1) ) {
//             for third <- (second + 1) until ( number.size ) {
//                 if(isTriple(number(first), number(second), number(third))) {
//                     combination += 1
//                 }
//             }
//         }
//     }
//     return combination
// }
