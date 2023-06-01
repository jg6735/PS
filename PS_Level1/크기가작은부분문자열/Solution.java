package PS_Level1.크기가작은부분문자열;

// https://school.programmers.co.kr/learn/courses/30/lessons/147355
class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)) {
                answer++;
            }
        }

        return answer;
    }
}