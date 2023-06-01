package PS_Level0.연속된수의합;

public class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];

//        for (int i = -100; i <= 100; i++) {
//            int sum = 0;
//            for (int j = 0; j < num; j++) {
//                sum += i + j;
//            }
//
//            if (sum == total) {
//                for (int j = 0; j < num; j++) {
//                    answer[j] = i + j;
//                }
//            }
//        }

        int check = num * (num + 1) / 2;
        int start = (total - check) / num + 1;
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start + i;
        }

        return answer;
    }
}
