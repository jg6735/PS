package PS_Level1.체육복;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                if (i - 1 >= 0 && arr[i - 1] == 0) {
                    arr[i - 1]++;
                    arr[i]--;
                } else if (i + 1 < arr.length && arr[i + 1] == 0) {
                    arr[i + 1]++;
                    arr[i]--;
                }
            }
        }

        for (int ans : arr) {
            if (ans == 1) {
                answer++;
            }
        }

        return answer;
    }
}
