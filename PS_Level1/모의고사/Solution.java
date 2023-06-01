package PS_Level1.모의고사;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class Solution {
    private static int[] arr1 = new int[]{1, 2, 3, 4, 5};
    private static int[] arr2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static int[] arr3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (arr1[i % arr1.length] == answers[i]) {
                scores[0]++;
            }

            if (arr2[i % arr2.length] == answers[i]) {
                scores[1]++;
            }

            if (arr3[i % arr3.length] == answers[i]) {
                scores[2]++;
            }
        }

        int max = 0;
        int length = 0;
        for (int score : scores) {
            if (score >= max) {
                max = score;
            }
        }

        for (int score : scores) {
            if (score == max) {
                length++;
            }
        }

        int[] answer = new int[length];
        for (int i = 0, j = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                answer[j++] = i + 1;
            }
        }

        return answer;
    }
}
