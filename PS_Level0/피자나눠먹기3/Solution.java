package PS_Level0.피자나눠먹기3;

public class Solution {
    public int solution(int slice, int n) {
        int answer = 1;

        while (true) {
            if ((answer * slice) / n >= 1) {
                break;
            }

            answer++;
        }

        return answer;
    }
}
