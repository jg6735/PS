package PS_Level2.큰수만들기;

// https://school.programmers.co.kr/learn/courses/30/lessons/42883
class Solution {
    public String solution(String number, int k) {
        StringBuilder builder = new StringBuilder();

        int start = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = start; j < k + i + 1; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }

            builder.append(max);
        }

        return builder.toString();
    }
}