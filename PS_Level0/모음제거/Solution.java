package PS_Level0.모음제거;

public class Solution {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            char c = my_string.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }

            builder.append(c);
        }

        return builder.toString();
    }
}
