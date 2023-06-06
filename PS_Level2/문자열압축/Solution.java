package PS_Level2.문자열압축;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int length = 1; length <= s.length() / 2; length++) {
            StringBuilder builder = new StringBuilder();
            String current = s.substring(0, length);
            int count = 1;

            for (int i = length; i < s.length(); i += length) {
                String next = s.substring(i, Math.min(i + length, s.length()));
                if (current.equals(next)) {
                    count++;
                } else {
                    if (count > 1) {
                        builder.append(count);
                    }

                    builder.append(current);
                    current = next;
                    count = 1;
                }
            }

            if (count > 1) {
                builder.append(count);
            }

            builder.append(current);
            answer = Math.min(answer, builder.length());

            if (length > answer) {
                break;
            }
        }

        return answer;
    }
}