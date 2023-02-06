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

/*
테스트 1 〉	통과 (6.94ms, 90.2MB)
테스트 2 〉	통과 (6.72ms, 90.8MB)
테스트 3 〉	통과 (6.58ms, 89.3MB)
테스트 4 〉	통과 (6.56ms, 90.2MB)
테스트 5 〉	통과 (11.66ms, 89.2MB)
테스트 6 〉	통과 (7.32ms, 90.1MB)   
테스트 7 〉	통과 (8.70ms, 90.2MB)
테스트 8 〉	통과 (9.02ms, 90.2MB)
테스트 9 〉	통과 (9.32ms, 88.6MB)
테스트 10 〉	통과 (14.78ms, 91.5MB)
테스트 11 〉	통과 (10.07ms, 90.3MB)
테스트 12 〉	통과 (55.34ms, 93.6MB)
테스트 13 〉	통과 (53.82ms, 92MB)
테스트 14 〉	통과 (54.14ms, 92.4MB)
테스트 15 〉	통과 (152.13ms, 102MB)
테스트 16 〉	통과 (133.70ms, 99.6MB)
테스트 17 〉	통과 (145.41ms, 99.6MB)
테스트 18 〉	통과 (141.97ms, 102MB)
테스트 19 〉	통과 (177.94ms, 97.5MB)
테스트 20 〉	통과 (121.53ms, 99.5MB)
테스트 21 〉	통과 (137.14ms, 101MB)
테스트 22 〉	통과 (171.94ms, 99.1MB)
테스트 23 〉	통과 (171.85ms, 101MB)
테스트 24 〉	통과 (171.41ms, 97.2MB)
테스트 25 〉	통과 (181.68ms, 100MB)
테스트 26 〉	통과 (6.10ms, 90.1MB)
채점 결과
*/