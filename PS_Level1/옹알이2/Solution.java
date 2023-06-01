package PS_Level1.옹알이2;

// https://school.programmers.co.kr/learn/courses/30/lessons/133499
public class Solution {
    private static final String[] BABBLINGS = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;

        for (String str : babbling) {
            String checkedBabbling = checkBabbling(str);

            if (checkedBabbling.replace(" ", "").length() == 0) {
                answer++;
            }
        }

        return answer;
    }

    private static String checkBabbling(String babbling) {
        for (String str : BABBLINGS) {
            if (babbling.indexOf(str.repeat(2)) != -1) {
                babbling = babbling.replace(str.repeat(2), "*");
            }

            babbling = babbling.replace(str, " ");
        }

        return babbling;
    }
}
