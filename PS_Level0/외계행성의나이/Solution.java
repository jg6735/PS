package PS_Level0.외계행성의나이;

public class Solution {
    public String solution(int age) {
        String answer = "";
        String str = String.valueOf(age);
        for (int i = 0; i < str.length(); i++) {
            answer += (char) (str.charAt(i) - '0' + 'a');
        }

        return answer;
    }
}
