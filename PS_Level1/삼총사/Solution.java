package PS_Level1.삼총사;

// https://school.programmers.co.kr/learn/courses/30/lessons/131705
public class Solution {
    private static int answer;

    public int solution(int[] number) {
        answer = 0;
        getTriple(number, 0, 0, 0);
        return answer;
    }

    private static void getTriple(int[] number, int index, int count, int sum) {
        if (count == 3) {
            if (sum == 0) {
                answer++;
            }

            return;
        }

        for (int i = index; i < number.length; i++) {
            getTriple(number, i + 1, count + 1, sum + number[i]);
        }
    }
}
