package PS_Level0.다음에올숫자;

public class Solution {
    public int solution(int[] common) {
        int answer = 0;

        if (Math.abs(common[2] - common[1]) == Math.abs(common[1] - common[0])) {
            answer = common[common.length - 1] + common[1] - common[0];
        } else {
            answer = common[common.length - 1] * common[1] / common[0];
        }

        return answer;
    }
}
