package PS_Level1.비밀지도;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < answer.length; i++) {
            builder.append(Integer.toBinaryString(arr1[i] | arr2[i]));
            builder.insert(0, "0".repeat(n - builder.length()));
            answer[i] = builder.toString().replace("1", "#").replace("0", " ");
            builder.setLength(0);
        }

        return answer;
    }
}
