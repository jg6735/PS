package PS_Level1.이상한문자만들기;

public class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();

        boolean check = true;
        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                builder.append(" ");
                check = true;
                continue;
            }

            if (check) {
                builder.append(Character.toUpperCase(c));
                check = false;
            } else {
                builder.append(Character.toLowerCase(c));
                check = true;
            }
        }

        return builder.toString();
    }
}
