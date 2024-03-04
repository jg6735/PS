import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, M, answer;
    private static char[][] map;
    private static boolean[][] visited;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0, 1));
        visited[0][0] = true;

        Coordinate cur;
        int curR, curC, curDistance, nextR, nextC;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curR = cur.getR();
            curC = cur.getC();
            curDistance = cur.getDistance();

            if (curR == N - 1 && curC == M - 1) {
                answer = Math.min(answer, curDistance);
            }

            for (int d = 0; d < 4; d++) {
                nextR = curR + DR[d];
                nextC = curC + DC[d];

                if (canVisit(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == '1') {
                    queue.add(new Coordinate(nextR, nextC, curDistance + 1));
                    visited[nextR][nextC] = true;
                }
            }
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        answer = Integer.MAX_VALUE;
        for (int r = 0; r < N; r++) {
            String input = in.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c);
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

    private static class Coordinate {
        private final int r;
        private final int c;
        private final int distance;

        public Coordinate(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getDistance() {
            return distance;
        }
    }
}