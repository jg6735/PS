package PS_Level1.문자열다루기기본;

public class Solution {
    public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) {
            for (char c : s.toCharArray()) {
                if (c - '0' < 0 || c - '0' > 9) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }
}
