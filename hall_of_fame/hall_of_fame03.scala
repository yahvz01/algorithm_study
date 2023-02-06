import scala.collection.mutable.PriorityQueue
import scala.math.Ordering.Int.{ reverse }

object Solution {
    def solution(k: Int, score: Vector[Int]): Vector[Int] =
        // 오늘 몇 번째 날인지 구한다.
        (for ( targetIdx <- 1 to score.length )
        yield {
            // 우선순위 큐 / 우리가 배웠던 유사 TreeSet
            // (정렬 가능한) 임시 데이터 저장소를 만든다.
            // "머리"에 가장 작은 숫자가 들어가는 데이터 저장소를 만든다.
            var dailyHoners = PriorityQueue[Int]()(reverse)
            // 0번째 날부터 ~ 몇 번째 날까지 데이터를 순회한다.
            for( currentIdx <- 0 until targetIdx )
            do {
                val currentValue = score.view(currentIdx)
                // 임시 데이터 저장소에 k보다 작은 데이터가 들어있으면 그냥 넣는다
                if(dailyHoners.length < k)
                    dailyHoners enqueue currentValue
                // 임시 데이터 저장소안에 K만큼 데이터가 들어있고
                // 임시 데이터 저장소의 머리에 있는 값보다 크다면
                else if(dailyHoners.head < currentValue) {
                    // 그 데이터를 빼고 넣는다
                    dailyHoners.dequeue()
                    dailyHoners enqueue currentValue
                }   
            }
            dailyHoners.dequeue()
        }).toVector
}