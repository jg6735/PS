package PS_Level1.가운데글자가져오기;

// https://school.programmers.co.kr/learn/courses/30/lessons/12903
public class Solution {
    public String solution(String s) {
        String answer = "";

        if (s.length() % 2 == 0) {
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            answer = s.substring(s.length() / 2, s.length() / 2 + 1);
        }

        return answer;
//        return s.substring(s.length() % 2 == 0 ? s.length() / 2 - 1 : s.length() / 2, s.length() / 2 + 1);
    }
}
