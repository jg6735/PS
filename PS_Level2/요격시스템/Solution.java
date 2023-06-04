package PS_Level2.요격시스템;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/181188
// 스케쥴링
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        // 타겟(s,e)중 e 좌표를 기준으로 오름차순 정렬한다.
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        // x좌표 선 긋기
        int x = 0;
        for (int[] target : targets) {
            int start = target[0];
            int targetEnd = target[1];

            // s와 e 좌표에서는 요격할 수 없으므로 선의 좌표와 같은 경우도 포함한다.
            if (start >= x) {
                x = targetEnd;
                answer++;
            }
        }

        return answer;
    }
}