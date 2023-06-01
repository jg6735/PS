package PS_Level0.OX퀴즈;

public class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];

        for (int i = 0; i < quiz.length; i++) {
            String[] arr = quiz[i].split(" ");
            int X = Integer.parseInt(arr[0]);
            int Y = Integer.parseInt(arr[2]);
            int Z = Integer.parseInt(arr[4]);

            if (arr[1].equals("+")) {
                answer[i] = X + Y == Z ? "O" : "X";
            } else {
                answer[i] = X - Y == Z ? "O" : "X";
            }
        }

        return answer;
    }
}
