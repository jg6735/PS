package PS_Level2.프렌즈4블록;

// https://school.programmers.co.kr/learn/courses/30/lessons/17679
class Solution {
    private static int check(int m, int n, char[][] map) {
        int count = 0;
        boolean[][] checked = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == '.') {
                    continue;
                }

                check(i, j, map, checked);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checked[i][j]) {
                    count++;
                    map[i][j] = '.';
                }
            }
        }

        return count;
    }

    private static void check(int r, int c, char[][] map, boolean[][] checked) {
        for (int i = r; i < r + 2; i++) {
            for (int j = c; j < c + 2; j++) {
                if (map[i][j] != map[r][c]) {
                    return;
                }
            }
        }

        for (int i = r; i < r + 2; i ++) {
            for (int j = c; j < c + 2; j++) {
                checked[i][j] = true;
            }
        }
    }

    private static void drop(int m, int n, char[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (map[j][i] == '.') {
                    for (int r = j - 1; r >= 0; r--) {
                        if (map[r][i] != '.') {
                            map[j][i] = map[r][i];
                            map[r][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] map = new char[m][n];
        for (int i = 0; i < board.length; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            int count = check(m, n, map);
            if (count == 0) {
                break;
            }

            answer += count;
            drop(m, n, map);
        }

        return answer;
    }
}