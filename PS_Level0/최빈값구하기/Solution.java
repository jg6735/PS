package PS_Level0.최빈값구하기;

import java.util.Arrays;

public class Solution {
    public int solution(int[] array) {
        int answer = 0;

        int[] counts = new int[1000];
        for (int num : array) {
            counts[num]++;
        }

        int max = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > max) {
                max = counts[i];
                answer = i;
            }
        }

        Arrays.sort(counts);
        if (counts[counts.length - 1] == counts[counts.length - 2]) {
            answer = -1;
        }

        return answer;
    }
}
