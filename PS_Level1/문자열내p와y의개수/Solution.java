package PS_Level1.문자열내p와y의개수;

public class Solution {
    boolean solution(String s) {
        char[] arr = new char['z' + 1];
        for (char c : s.toLowerCase().toCharArray()) {
            arr[c]++;
        }

        return arr['p'] == arr['y'];
    }
}
