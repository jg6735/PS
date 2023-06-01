package PS_Level1.삼진법뒤집기;

// https://school.programmers.co.kr/learn/courses/30/lessons/68935
public class Solution {
    public int solution(int n) {
        StringBuilder builder = new StringBuilder();

        while (n > 0) {
            builder.append(n % 3);
            n /= 3;
        }

        return Integer.parseInt(builder.toString(), 3);
    }
}
