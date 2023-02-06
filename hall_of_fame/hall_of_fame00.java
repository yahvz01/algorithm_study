import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.List;

// 자바로 푼 해설

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> answer = new LinkedList<Integer>();


        // 오늘 몇 번째 날인지 구한다.
        for( var target_day = 1; target_day <= score.length; ++target_day ) {

            // 우선순위 큐 / 우리가 배웠던 유사 TreeSet
            // (정렬 가능한) 임시 데이터 저장소를 만든다.
            // "머리"에 가장 작은 숫자가 들어가는 데이터 저장소를 만든다.
            var dailyHoner = new PriorityQueue<Integer>();

            // 0번째 날부터 ~ 몇 번째 날까지 데이터를 순회한다.
            for( var current_day = 0; current_day < target_day; ++current_day ) {
                var currentValue = score[current_day];
                
                if( dailyHoner.size() < k) {
                    // 임시 데이터 저장소에 k보다 작은 데이터가 들어있으면 그냥 넣는다
                    dailyHoner.add(currentValue);

                } else if( dailyHoner.peek() < currentValue) {
                    // 임시 데이터 저장소안에 K만큼 데이터가 들어있고
                    // 임시 데이터 저장소의 머리에 있는 값보다 크다면
                    dailyHoner.poll();
                    dailyHoner.add(currentValue);
                }
            }
            answer.add(dailyHoner.poll());
        }

        // Convert to List to Array 
        int answerSize = answer.size();
        int[] convertedAnswer = new int[answer.size()];
        for(var idx = 0; idx < answerSize; ++idx) {
            convertedAnswer[idx] = answer.get(idx);
        }
        
        // return answer.toArray();
        return convertedAnswer;
    }
}