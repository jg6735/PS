package PS_Level0.옹알이;

public class Solution {
    private static String[] arr = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babbling) {
        int answer = 0;

        for (String str : babbling) {
            for (String temp : arr) {
                str = str.replace(temp, " ");
            }

            if (str.replaceAll(" ", "").length() == 0) {
                answer++;
            }
        }

        return answer;
    }
}
