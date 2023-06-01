package PS_Level0.배열회전시키기;

public class Solution {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (direction.equals("right")) {
                answer[i] = numbers[(numbers.length * 2 - 1 + i) % numbers.length];
            } else {
                answer[i] = numbers[(numbers.length * 2 - 1 - i) % numbers.length];
            }
        }

        return answer;
    }
}
