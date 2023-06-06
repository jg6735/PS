package PS_Level2.삼각달팽이;

public class Solution {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int v = 1;
        int x = 0;
        int y = 0;
        int d = 0;

        while (true) {
            arr[y][x] = v++;
            int nextX = dx[d] + x;
            int nextY = dy[d] + y;

            if (nextX == n || nextY == n || nextX == -1 || nextY == -1 || arr[nextY][nextX] != 0) {
                d = (d + 1) % 3;
                nextX = dx[d] + d;
                nextY = dy[d] + d;

                if (nextX == n || nextY == n || nextX == -1 || nextY == -1 || arr[nextY][nextX] != 0) {
                    break;
                }
            }

            x = nextX;
            y = nextY;
        }

        int[] answer = new int[v - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = arr[i][j];
            }
        }

        return answer;
    }
}
