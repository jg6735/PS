package PS_Level0.안전지대;

public class Solution {
    private static final int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static final int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public int solution(int[][] board) {
        int answer = 0;

        int[][] check = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    check[i][j] = 1;
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[i].length) {
                            continue;
                        }

                        check[ny][nx] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[i].length; j++) {
                if (check[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
