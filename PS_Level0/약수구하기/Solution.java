package PS_Level0.약수구하기;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int n) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                queue.offer(i);
            }
        }
        queue.offer(n);

        int[] answer = new int[queue.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
