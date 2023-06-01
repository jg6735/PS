package PS_Level0.한번만등장한문자;

public class Solution {
    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        int[] arr = new int['z' + 1];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                builder.append((char) i);
            }
        }

        return builder.toString();
    }
}
