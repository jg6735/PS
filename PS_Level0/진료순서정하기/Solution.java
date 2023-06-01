package PS_Level0.진료순서정하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] temp = Arrays.copyOf(emergency, emergency.length);
        Arrays.sort(temp);

        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (temp[i] == emergency[j]) {
                    answer[i] = emergency.length - j;
                }
            }
        }

        return answer;
    }
}
