import collection.mutable.ArrayBuffer

class DailyHonors( val max_length : Int ) {
    val scores = ArrayBuffer.empty[Int]
    
    def insert( data : Int ) = 
        if( scores.length < max_length ) {
            scores += data
            scores = scores.sort
        } else if( data > scores.head ) {
            scores(0) = data
            scores = scores.sorted
        } else
            ()
    def getMinValue = this.scores.head
}

object DailyHonors {
    def apply(max_length : Int) = new DailyHonors(max_length)
}

object Solution {
    def main( args : Array[String]) = {
        val HONERS_MAX_LENGTH = 3
        val test_value = (for( _ <- 1 to 30; data = (Math.random * 100).toInt ) yield data).toVector
        println(test_value)
        val result = solution(HONERS_MAX_LENGTH, test_value)
        println(result)
    }

    def solution(k: Int, score: Vector[Int]): Vector[Int] =
        (for ( targetIdx <- 1 to score.length )
        yield {
            val dailyHoners = DailyHonors(k)
            for ( currentIdx <- 0 until targetIdx ) {
                dailyHoners.insert(score(currentIdx))
            }
            dailyHoners.getMinValue
        }).toVector
}
/*
테스트 1 〉	통과 (6.24ms, 89.8MB)
테스트 2 〉	통과 (6.32ms, 92.1MB)
테스트 3 〉	통과 (4.68ms, 91MB)
테스트 4 〉	통과 (4.13ms, 91MB)
테스트 5 〉	통과 (6.39ms, 89.3MB)
테스트 6 〉	통과 (3.89ms, 90.9MB)
테스트 7 〉	통과 (6.23ms, 90.9MB)
테스트 8 〉	통과 (6.58ms, 89.9MB)
테스트 9 〉	통과 (7.88ms, 89.7MB)
테스트 10 〉	통과 (10.55ms, 89.9MB)
테스트 11 〉	통과 (13.60ms, 90.2MB)
테스트 12 〉	통과 (74.69ms, 114MB)
테스트 13 〉	통과 (95.60ms, 125MB)
테스트 14 〉	통과 (76.73ms, 108MB)
테스트 15 〉	통과 (185.95ms, 134MB)
테스트 16 〉	통과 (159.18ms, 125MB)
테스트 17 〉	통과 (181.58ms, 135MB)
테스트 18 〉	통과 (203.85ms, 143MB)
테스트 19 〉	통과 (29.28ms, 91.4MB)
테스트 20 〉	통과 (29.20ms, 92.5MB)
테스트 21 〉	통과 (41.55ms, 95.8MB)
테스트 22 〉	통과 (31.97ms, 92.3MB)
테스트 23 〉	통과 (32.77ms, 93.1MB)
테스트 24 〉	통과 (41.22ms, 91.1MB)
테스트 25 〉	통과 (41.22ms, 92.7MB)
테스트 26 〉	통과 (4.47ms, 89.9MB)
*/