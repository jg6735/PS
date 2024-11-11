import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int[][] board, air;
    private static int N, M, cheeseCount, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cheeseCount = 0;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
                if (board[r][c] == 1) {
                    cheeseCount++;
                }
            }
        }

        while (cheeseCount > 0) {
            air = new int[N][M];
            findCheese();
            meltCheese();
            answer++;
        }

        System.out.print(answer);
    }

    private static void findCheese() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        air[0][0] = -1;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];
                if (!isIn(nextR, nextC)) {
                    continue;
                }

                if (board[nextR][nextC] == 1) {
                    air[nextR][nextC]++;
                } else if (board[nextR][nextC] == 0 && air[nextR][nextC] == 0) {
                    air[nextR][nextC] = -1;
                    queue.add(new Coordinate(nextR, nextC));
                }
            }
        }
    }

    private static void meltCheese() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (air[r][c] >= 2) {
                    board[r][c] = 0;
                    cheeseCount--;
                }
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}

class Coordinate {

    private int r;
    private int c;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}