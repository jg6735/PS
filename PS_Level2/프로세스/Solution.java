package PS_Level2.프로세스;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42587
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            max = Math.max(max, priorities[i]);
        }

        while (!queue.isEmpty()) {
            // 인덱스 꺼내기
            int index = queue.poll();

            // 현재 우선순위보다 더 높은 우선순위가 있다면 큐에 넣고 넘어가기
            if (max > priorities[index]) {
                queue.offer(index);
            // 더 높은 우선순위가 없다면
            } else {
                priorities[index] = -1; // 프로세스 실행
                max = 0; // 높은 우선순위 초기화

                // 현재 인덱스를 제외한 우선순위 최댓값 구하기
                for (int i = 0; i < priorities.length; i++) {
                    if (i == index) {
                        continue;
                    }

                    max = Math.max(max, priorities[i]);
                }

                answer++;

                if (index == location) {
                    break;
                }
            }
        }

        return answer;
    }
}