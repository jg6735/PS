package PS_Level0.짝수홀수개수;

public class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];

        for (int num : num_list) {
            if (num % 2 == 0) {
                answer[0]++;
            }
        }

        answer[1] = num_list.length - answer[0];

        return answer;
    }
}
