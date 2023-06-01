package PS_Level0.중복된문자제거;

public class Solution {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder();
        int[] array = new int['z' + 1];

        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);

            if (array[ch] == 0) {
                builder.append(ch);
            }

            array[ch]++;
        }

        return builder.toString();
    }
}
