package PS_Level2.혼자서하는틱택토;

// https://school.programmers.co.kr/learn/courses/30/lessons/160585
class Solution {
    // O, X 개수 세기
    private static int count(String[] board, char c) {
        int cnt = 0;
        for (String str : board) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == c) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    // O나 X가 이긴 경우 확인하기
    private static boolean check(String[] board, char c) {
        // 가로 체크
        for (String str : board) {
            if (str.charAt(0) == c
                    && str.charAt(1) == c
                    && str.charAt(2) == c) {
                return true;
            }
        }

        // 세로 체크
        for (int i = 0; i < board.length; i++) {
            if (board[0].charAt(i) == c
                    && board[1].charAt(i) == c
                    && board[2].charAt(i) == c) {
                return true;
            }
        }

        // 대각선 체크
        if (board[0].charAt(0) == c
                && board[1].charAt(1) == c
                && board[2].charAt(2) == c) {
            return true;
        }

        // 대각선 체크
        return board[2].charAt(0) == c
                && board[1].charAt(1) == c
                && board[0].charAt(2) == c;
    }

    public int solution(String[] board) {
        int answer = 1;

        int oCount = count(board, 'O');
        int xCount = count(board, 'X');

        // X가 O보다 많거나 O가 X보다 2개 이상 많으면 비정상
        if (xCount > oCount || oCount - 1 > xCount) {
            return 0;
        }

        // O가 이길 경우 O와 X의 개수가 같으면 비정상
        if (check(board, 'O') && (oCount == xCount)) {
            return 0;
        }

        // X가 이길 경우 O가 X보다 많으면 비정상
        if (check(board, 'X') && (oCount > xCount)) {
            return 0;
        }

        return answer;
    }
}