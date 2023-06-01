package PS_Level0.암호해독;

public class Solution {
    public String solution(String cipher, int code) {
        StringBuilder builder = new StringBuilder();

        for (int i = code - 1; i < cipher.length(); i += code) {
            builder.append(cipher.charAt(i));
        }

        return builder.toString();
    }
}
