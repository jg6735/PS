package PS_Level1.x만큼간격이있는n개의숫자;

public class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];

        long num = x;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = num;
            num += x;
        }

        return answer;
    }
}
