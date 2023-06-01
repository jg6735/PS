package PS_Level1.시저암호;

public class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ' ') {
                sb.append(arr[i]);
                continue;
            }

            arr[i] += n;
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                if (arr[i] > 'z') {
                    arr[i] -= 26;
                }
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                if (arr[i] > 'Z') {
                    arr[i] -= 26;
                }
            }

            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
