package PS_Level2.과제진행하기;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://school.programmers.co.kr/learn/courses/30/lessons/176962
/*
1. 진행중이던 과제가 끝났을 때
    1) 멈춘 과제가 있다면 멈춘 과제부터
    2) 멈춘 과제와 새로 시작해야하는 과제가 같은 시각에 있다면 새로 시작해야하는 과제부터
2. 멈춘 과제가 여러개라면, 가장 최근에 멈춘 과제부터
 */
class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Plan[] arr = new Plan[plans.length];
        for (int i = 0; i < plans.length; i++) {
            arr[i] = new Plan(plans[i][0], plans[i][1], Integer.parseInt(plans[i][2]));
        }

        // 시작 시간순으로 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> o1.getStartTime() - o2.getStartTime());

        // 멈춘 과제 저장용 덱
        Deque<Plan> remain = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            // 현재 과제
            Plan cur = arr[i];
            // 다음 과제
            Plan next = arr[i + 1];

            // 현재 과제를 끝내는데 걸리는 시간이 다음 과제 시작 시간을 넘으면
            if (cur.getEndTime() > next.getStartTime()) {
                // 가능한 만큼 과제를 하고 덱에 저장하기
                cur.setPlaytime(cur.getEndTime() - next.getStartTime());
                remain.push(cur);
                continue;
            }

            // 현재 과제를 끝내는데 걸리는 시간이 충분하면 과제 마치기
            answer[index++] = cur.getName();
            int gapTime = next.getStartTime() - cur.getEndTime();
            // 다음 과제 시작하기까지 시간이 남아 있고, 멈춘 과제가 있다면
            while (gapTime > 0 && !remain.isEmpty()) {
                Plan plan = remain.peek();
                // 멈춘 과제 진행하기(남은 시간동안 가능한 만큼)
                int time = plan.getPlaytime() - gapTime;
                plan.setPlaytime(time);

                gapTime = time * -1;
                if (time > 0) {
                    break;
                }

                answer[index++] = remain.pop().getName();
            }
        }

        answer[index++] = arr[arr.length - 1].getName();
        while (!remain.isEmpty()) {
            answer[index++] = remain.pop().getName();
        }

        return answer;
    }

    static class Plan {
        private String name;
        private int startTime;
        private int playtime;

        public Plan(String name, String startTime, int playtime) {
            this.name = name;
            this.startTime = parseTimeToInt(startTime);
            this.playtime = playtime;
        }

        public String getName() {
            return name;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getPlaytime() {
            return playtime;
        }

        public void setPlaytime(int time) {
            playtime = time;
        }

        private int parseTimeToInt(String startTime) {
            String[] split = startTime.split(":");
            return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }

        public int getEndTime() {
            return startTime + playtime;
        }
    }
}