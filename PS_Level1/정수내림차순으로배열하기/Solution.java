package PS_Level1.정수내림차순으로배열하기;

import java.util.Arrays;

public class Solution {
    public long solution(long n) {
        StringBuilder builder = new StringBuilder();
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]);
        }

        return Long.parseLong(builder.toString());
    }
}
