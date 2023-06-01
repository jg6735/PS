package PS_Level1.예산;

import java.util.Arrays;

public class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int sum = 0;
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            sum += d[i];
            if (sum > budget) {
                break;
            }

            count++;
        }

        return count;
    }
}
