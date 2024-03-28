import java.util.*;

class Solution {
    
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0;
        long sum2 = 0;
        Deque<Integer> deque1 = new ArrayDeque<>();
        for (int number : queue1) {
            deque1.add(number);
            sum1 += number;
        }
        
        Deque<Integer> deque2 = new ArrayDeque<>();
        for (int number : queue2) {
            deque2.add(number);
            sum2 += number;
        }
        
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        
        int answer = 0;
        long half = (sum1 + sum2) / 2;
        while (true) {
            if (answer > (queue1.length + queue2.length) * 2) {
                return -1;
            }
            
            int poll;
            if (sum1 > half) {
                poll = deque1.poll();
                deque2.add(poll);
                sum1 -= poll;
                sum2 += poll;
            } else if (sum1 < half) {
                poll = deque2.poll();
                deque1.add(poll);
                sum1 += poll;
                sum2 -= poll;
            } else {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}