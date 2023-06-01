package PS_Level0.대문자와소문자;

public class Solution {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder();

        for (char c : my_string.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                builder.append((char) (c - 32));
            } else {
                builder.append((char) (c + 32));
            }
        }

        return builder.toString();
    }
}
