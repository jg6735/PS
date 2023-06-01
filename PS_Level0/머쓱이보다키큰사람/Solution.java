package PS_Level0.머쓱이보다키큰사람;

public class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;

        for (int n : array) {
            if (n > height) {
                answer++;
            }
        }

        return answer;
    }
}
