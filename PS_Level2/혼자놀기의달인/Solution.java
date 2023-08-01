package PS_Level2.혼자놀기의달인;

import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/131130
class Solution {
    private static int dfs(int index, int count, int[] cards, boolean[] visited) {
        // 열지 않은 상자면
        if (!visited[index]) {
            // 열고 상자 속에 적힌 숫자를 인덱스로 탐색
            visited[index] = true;
            count = dfs(cards[index] - 1, count + 1, cards, visited);
        }

        return count;
    }

    public int solution(int[] cards) {
        // 최고 점수를 얻기 위해 내림차순 우선순위큐
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        boolean[] visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if (!visited[i]) {
                pq.add(dfs(i, 0, cards, visited));
            }
        }

        if (pq.size() < 2) {
            return 0;
        }

        return pq.poll() * pq.poll();
    }
}