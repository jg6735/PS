package PS_Level1.문자열내림차순으로배치하기;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }

        return builder.toString();
    }
}
