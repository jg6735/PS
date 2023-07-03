package PS_Level2.더맵게;

import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42626
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 스코빌 지수가 낮은 음식이 우선적으로 필요하므로 우선순위큐에 저장
        Queue<Integer> queue = new PriorityQueue<>();
        for (int scale : scoville) {
            queue.offer(scale);
        }

        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복
        while (queue.size() > 1 && queue.peek() < K) {
            int firstScale = queue.poll();
            int secondScale = queue.poll();
            queue.offer(firstScale + secondScale * 2);
            answer++;
        }

        // 더 이상 섞을 수 없는 경우 -1 반환
        return queue.peek() < K ? -1 : answer;
    }
}