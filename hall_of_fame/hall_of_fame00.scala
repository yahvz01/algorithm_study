object Solution {
    def solution(k: Int, score: Vector[Int]): Vector[Int] =
        (for ( targetIdx <- 1 to score.length )
        yield {
            (for ( currentIdx <- 0 until targetIdx )
            yield
                score.view(currentIdx))
                .sorted(Ordering.Int.reverse)
                .take(k)
                .reduceLeft( _ min _ )
        }).toVector
}
