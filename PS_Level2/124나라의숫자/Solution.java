package PS_Level2._124나라의숫자;

// https://school.programmers.co.kr/learn/courses/30/lessons/12899
class Solution {
    public String solution(int n) {
        StringBuilder builder = new StringBuilder();

        while (n > 0) {
            if (n % 3 == 0) {
                builder.insert(0, "4");
                n = n / 3 - 1;
            } else {
                builder.insert(0, n % 3);
                n /= 3;
            }
        }

        return builder.toString();
    }
}