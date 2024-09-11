import java.io.*;
import java.util.*;

public class Main {
    private static final int EAST = 0, SOUTH = 1, WEST = 2, NORTH = 3;
    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    private static int N, M, K, score;
    private static int r = 0, c = 0, direction = EAST;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice();
        for (int i = 0; i < K; i++) {
            move(dice);
        }

        System.out.print(score);
    }

    private static void move(Dice dice) {
        int nextR = r + DR[direction];
        int nextC = c + DC[direction];

        if (!isIn(nextR, nextC)) {
            direction = (direction + 2) % 4;
            nextR = r + DR[direction];
            nextC = c + DC[direction];
        }

        dice.roll(direction);

        r = nextR;
        c = nextC;
        score += getScore(r, c);

        int bottom = dice.getBottom();
        int diceValue = map[r][c];
        if (bottom > diceValue) {
            direction = (direction + 1) % 4;
        } else if (bottom < diceValue) {
            direction = (direction + 3) % 4;
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }

    private static int getScore(int startR, int startC) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;

        int start = map[startR][startC];
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];

            for (int i = 0; i < 4; i++) {
                int nextR = curR + DR[i];
                int nextC = curC + DC[i];

                if (isIn(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == start) {
                    visited[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC});
                    count++;
                }
            }
        }

        return start * count;
    }

    private static class Dice {
        private int top = 1, bottom = 6, left = 4, right = 3, front = 5, back = 2;

        public void roll(int dir) {
            int temp;
            if (dir == EAST) {
                temp = top;
                top = left;
                left = bottom;
                bottom = right;
                right = temp;
            } else if (dir == SOUTH) {
                temp = top;
                top = back;
                back = bottom;
                bottom = front;
                front = temp;
            } else if (dir == WEST) {
                temp = top;
                top = right;
                right = bottom;
                bottom = left;
                left = temp;
            } else if (dir == NORTH) {
                temp = top;
                top = front;
                front = bottom;
                bottom = back;
                back = temp;
            }
        }

        public int getBottom() {
            return bottom;
        }
    }
}