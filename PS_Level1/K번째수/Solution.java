package PS_Level1.K번째수;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];
            int[] temp = new int[end - start + 1];

            for (int j = start - 1, n = 0; j < end; j++, n++) {
                temp[n] = array[j];
            }

            Arrays.sort(temp);
            answer[i] = temp[k - 1];
        }

        return answer;
    }
}
