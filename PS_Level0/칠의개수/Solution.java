package PS_Level0.칠의개수;

public class Solution {
    public int solution(int[] array) {
        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            while (number != 0) {
                if (number % 10 == 7) {
                    answer++;
                }

                number /= 10;
            }
        }

        return answer;
    }
}
