package PS_Level2.다리를지나는트럭;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42583
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        // 다리 길이만큼 무게 배분(0으로 초기화)
        for (int i = 0; i < bridge_length; i++) {
            queue.offer(0);
        }

        int index = 0;

        while (!queue.isEmpty()) {
            // 마지막 트럭이 다리에 올랐다면 남은 다리 길이만큼 카운트
            if (index == truck_weights.length) {
                while (!queue.isEmpty()) {
                    queue.poll();
                    answer++;
                }

                break;
            }

            // 진입하려는 트럭 무게
            int truckWeight = truck_weights[index];
            // 다리를 건너간 트럭
            int completedTruck = queue.poll();

            // 트럭이 다리를 건넜다면 그만큼 다리가 견딜 수 있는 무게 추가
            if (completedTruck != 0) {
                weight += completedTruck;
            }

            // 진입하려는 트럭이 다리에 오를 수 있으면
            if (weight - truckWeight >= 0) {
                index++;
                queue.offer(truckWeight);
                weight -= truckWeight;
            // 다리에 오를 수 없으면
            } else {
                queue.offer(0);
            }

            answer++;
        }

        return answer;
    }
}