package PS_Level0.문자열안에문자열;

public class Solution {
    public int solution(String str1, String str2) {
        int answer = str1.contains(str2) ? 1 : 2;
        return answer;
    }
}
