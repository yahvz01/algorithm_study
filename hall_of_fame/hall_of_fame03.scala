import scala.collection.mutable.PriorityQueue
import scala.math.Ordering.Int.{ reverse }

object Solution {
    def solution(k: Int, score: Vector[Int]): Vector[Int] =
        (for ( targetIdx <- 1 to score.length )
        yield {
            var dailyHoners = PriorityQueue[Int]()(reverse)
            for( currentIdx <- 0 until targetIdx )
            do {
                val currentValue = score.view(currentIdx)
                if(dailyHoners.length < k)
                    dailyHoners enqueue currentValue
                else if(dailyHoners.head < currentValue) {
                    dailyHoners enqueue currentValue
                    dailyHoners.dequeue()
                }   
            }
            dailyHoners.dequeue()
        }).toVector
}

// 모자라면 그냥 넣고
// 같은데, 크면 넣고 빼고
