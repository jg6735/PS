package PS_Level0.특정문자제거하기;

public class Solution {
    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter, "");
    }
}
