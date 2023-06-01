package PS_Level1.문자열나누기;

// https://school.programmers.co.kr/learn/courses/30/lessons/140108
class Solution {
    public int solution(String s) {
        int answer = 0;

        char c = s.charAt(0);
        int x = 1;
        int y = 0;

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                x++;
            } else {
                y++;
            }

            if (x == y) {
                if (i + 1 == s.length()) {
                    answer++;
                    break;
                }

                answer++;
                c = s.charAt(i + 1);
                x = 0;
                y = 0;
            } else if (i == s.length() - 1) {
                answer++;
            }
        }

        return answer;
    }
}