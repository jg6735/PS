package PS_Level0.가까운수;

public class Solution {
    public int solution(int[] array, int n) {
        int answer = array[0];

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(answer - n) == Math.abs(array[i] - n)) {
                if (array[i] < answer) {
                    answer = array[i];
                } else {
                    continue;
                }
            }

            if (Math.abs(array[i] - n) < Math.abs(answer - n)) {
                answer = array[i];
            }
        }

        return answer;
    }
}
