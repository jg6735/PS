package PS_Level0.치킨쿠폰;

public class Solution {
    public int solution(int chicken) {
        int answer = 0;

        while (chicken > 0) {
            if (chicken - 10 >= 0) {
                answer++;
                chicken++;
            }

            chicken -= 10;
        }

        return answer;
    }
}
