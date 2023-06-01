package PS_Level0.문자반복출력하기;

public class Solution {
    public String solution(String my_string, int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            builder.append(Character.toString(my_string.charAt(i)).repeat(n));
        }

        return builder.toString();
    }
}
