package PS_Level1.제일작은수제거하기;

public class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int[] answer = new int[arr.length - 1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        for (int i = 0, j = 0; i < answer.length; i++, j++) {
            if (arr[j] == min) {
                i--;
                continue;
            }

            answer[i] = arr[j];
        }


        return answer;
    }
}
