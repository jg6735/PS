package PS_Level1.로또의최고순위와최저순위;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/77484
public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int sum = 0;
        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                zero++;
                continue;
            }

            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    sum++;
                    break;
                }
            }
        }

        return new int[]{rank[sum + zero], rank[sum]};
    }
}