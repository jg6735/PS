package PS_Level2.광물캐기;

import java.util.PriorityQueue;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/172927
class Solution {
    private static final String DIAMOND = "diamond";
    private static final String IRON = "iron";

    private static class Fatigue {
        private final int index;
        private final int value;

        public Fatigue(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }

    private static int getAnswer(String[] minerals, int answer, int type, int index) {
        for (int start = index; start < index + 5 && start < minerals.length; start++) {
            if (type == 0) {
                answer++;
            } else if (type == 1) {
                if (minerals[start].equals(DIAMOND)) {
                    answer += 5;
                } else {
                    answer++;
                }
            } else {
                if (minerals[start].equals(DIAMOND)) {
                    answer += 25;
                } else if (minerals[start].equals(IRON)) {
                    answer += 5;
                } else {
                    answer++;
                }
            }
        }

        return answer;
    }

    private static void addQueueSortByValue(String[] minerals, Queue<Fatigue> queue) {
        for (int i = 0; i < minerals.length; i += 5) {
            int sum = 0;
            for (int j = 0; j < 5; j++) {
                if (i + j == minerals.length) {
                    break;
                }

                if (minerals[i + j].equals(DIAMOND)) {
                    sum += 25;
                } else if (minerals[i + j].equals(IRON)) {
                    sum += 5;
                } else {
                    sum += 1;
                }
            }

            queue.add(new Fatigue(i, sum));
        }
    }

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        Queue<Fatigue> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        addQueueSortByValue(minerals, queue);
        int count = 0;
        for (int pick : picks) {
            count += pick;
        }

        int type = 0;
        while (type < 3 && !queue.isEmpty()) {
            if (picks[type] == 0) {
                type++;
                continue;
            }

            int index = queue.poll().getIndex();
            if (index / 5 >= count) {
                continue;
            }

            answer = getAnswer(minerals, answer, type, index);
            picks[type]--;
        }

        return answer;
    }
}