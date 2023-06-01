package PS_Level1.자연수뒤집어배열로만들기;

public class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];

        for (int i = str.length() - 1, j = 0; i >= 0; i--, j++) {
            answer[j] = str.charAt(i) - '0';
        }

        return answer;
    }
}
