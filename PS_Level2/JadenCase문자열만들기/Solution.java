package PS_Level2.JadenCase문자열만들기;

// https://school.programmers.co.kr/learn/courses/30/lessons/12951
class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean blank = true;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == ' ') {
                blank = true;
                builder.append(c);
                continue;
            }

            if (blank) {
                if (Character.isAlphabetic(c)) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(c);
                }

                blank = false;
            } else {
                builder.append(c);
            }
        }

        return builder.toString();
    }
}