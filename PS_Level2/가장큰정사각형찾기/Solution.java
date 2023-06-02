package PS_Level2.가장큰정사각형찾기;

// https://school.programmers.co.kr/learn/courses/30/lessons/12905
class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        int[][] dp = new int[board.length + 1][board[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (board[i - 1][j - 1] == 0) {
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] > answer) {
                    answer = dp[i][j];
                }
            }
        }

        return answer * answer;

        /*
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1 && i > 0 && j > 0) {
                    board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                }

                if (board[i][j] > answer) {
                    answer = board[i][j];
                }
            }
        }

        return answer * answer;
        */
    }
}