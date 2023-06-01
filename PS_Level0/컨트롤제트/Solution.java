package PS_Level0.컨트롤제트;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Z")) {
                continue;
            }

            if (i <= arr.length - 1 && !arr[i + 1].equals("Z")) {
                answer += Integer.parseInt(arr[i]);
            }

            if (i == arr.length) {
                answer += Integer.parseInt(arr[i]);
            }
        }

        return answer;
    }
}
