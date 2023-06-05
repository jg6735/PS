package PS_Level2.최댓값과최솟값;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/12939
class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(arr);
        builder.append(arr[0]).append(" ").append(arr[arr.length - 1]);
        return builder.toString();
    }
}