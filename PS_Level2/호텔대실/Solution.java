package PS_Level2.호텔대실;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/155651
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] times = new int[book_time.length][2];

        for (int i = 0; i < book_time.length; i++) {
            times[i][0] = getTime(book_time[i][0]);
            times[i][1] = getTime(book_time[i][1]) + 10; // 청소 시간 10분 포함
        }

        // 대실 시작 시간 순으로 오름차순 정렬
        Arrays.sort(times, ((o1, o2) -> o1[0] - o2[0]));

        Queue<Integer> queue = new PriorityQueue<>();
        for (int[] time : times) {
            int start = time[0];
            int end = time[1];

            // 가장 첫 예약의 퇴실시간 삽입
            if (queue.isEmpty()) {
                queue.offer(end);
                continue;
            }

            // 이전 대실 종료 시각보다 시작 시간이 이후라면 같은 방을 써도 된다.
            if (queue.peek() <= start) {
                queue.poll();
                queue.offer(start);
            // 시작 시간이 이전 대실 종료 시각 내라면 새로운 방을 써야 한다.
            } else {
                queue.offer(end);
            }
        }

        return queue.size();
    }

    private static int getTime(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);

        return hour * 60 + minute;
    }
}