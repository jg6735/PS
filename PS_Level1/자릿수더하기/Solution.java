package PS_Level1.자릿수더하기;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String str = String.valueOf(n);
        for (char c : str.toCharArray()) {
            answer += c - '0';
        }

        return answer;
    }
}
