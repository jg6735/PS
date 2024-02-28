import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static Coordinate goal;
    private static int N, M;
    private static int[][] arr, result;
    private static boolean[][] visited;

    private static BufferedReader in;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        search(goal.getR(), goal.getC());
    }

    private static void search(int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (canVisit(nextR, nextC) && !visited[nextR][nextC]) {
                    queue.add(new Coordinate(nextR, nextC));
                    result[nextR][nextC] = result[curR][curC] + 1;
                    visited[nextR][nextC] = true;
                }
            }
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M && arr[r][c] != 0;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        result = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
                if (arr[r][c] == 2) {
                    goal = new Coordinate(r, c);
                }
            }
        }
    }

    private static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] != 0 && !visited[r][c]) {
                    builder.append(-1).append(" ");
                } else {
                    builder.append(result[r][c]).append(" ");
                }
            }

            builder.append("\n");
        }

        System.out.println(builder);
    }

    private static class Coordinate {
        private final int r;
        private final int c;

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
}