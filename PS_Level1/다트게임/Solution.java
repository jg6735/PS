package PS_Level1.다트게임;

// https://school.programmers.co.kr/learn/courses/30/lessons/17682
public class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        String[] scores = dartResult.replaceAll("[^0-9]", " ").trim().replace("  ", " ").split(" ");
        String[] options = dartResult.replaceAll("[0-9]", " ").trim().replace("  ", " ").split(" ");
        int[] answers = new int[3];

        for (int i = 0; i < 3; i++) {
            int score = Integer.parseInt(scores[i]);

            for (int j = 0; j < options[i].length(); j++) {
                char option = options[i].charAt(j);

                if (option == 'S') {
                    answers[i] += score;
                } else if (option == 'D') {
                    answers[i] += Math.pow(score, 2);
                } else if (option == 'T') {
                    answers[i] += Math.pow(score, 3);
                } else if (option == '*') {
                    if (i == 0) {
                        answers[i] *= 2;
                    } else {
                        answers[i] *= 2;
                        answers[i - 1] *= 2;
                    }
                } else if (option == '#') {
                    answers[i] *= -1;
                }
            }
        }

        for (int score : answers) {
            answer += score;
        }

        return answer;
    }
}