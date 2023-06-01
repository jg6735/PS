package PS_Level0.문자열뒤집기;

public class Solution {
    public String solution(String my_string) {
        StringBuilder builder = new StringBuilder(my_string);
        return builder.reverse().toString();
    }
}
