package PS_Level0.문자열정렬하기2;

import java.util.Arrays;

public class Solution {
    public String solution(String my_string) {
        char[] array = my_string.toLowerCase().toCharArray();
        Arrays.sort(array);
        String str = new String(array);
        return str;
    }
}
