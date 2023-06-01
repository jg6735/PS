package PS_Level0.캐릭터의좌표;

public class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        for (String key : keyinput) {
            switch (key) {
                case "left":
                    if (answer[0] == -board[0] / 2) {
                    } else {
                        answer[0]--;
                    }
                    break;
                case "right":
                    if (answer[0] == board[0] / 2) {
                    } else {
                        answer[0]++;
                    }
                    break;
                case "up":
                    if (answer[1] == board[1] / 2) {
                    } else {
                        answer[1]++;
                    }
                    break;
                case "down":
                    if (answer[1] == -board[1] / 2) {
                    } else {
                        answer[1]--;
                    }
                    break;
            }
        }

        return answer;
    }
}
