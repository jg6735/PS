package PS_Level1.부족한금액계산하기;

// https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;

        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }

        if (money - sum < 0) {
            answer = sum - money;
        } else {
            answer = 0;
        }

        return answer;
    }
}
