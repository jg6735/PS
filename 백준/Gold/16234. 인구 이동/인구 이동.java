import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, L, R, answer;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        while (true) {
            boolean[][] visited = new boolean[N][N];
            int cnt = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        cnt += search(r, c, visited);
                    }
                }
            }

            if (cnt > 0) {
                answer++;
            } else {
                break;
            }
        }
    }

    private static int search(int r, int c, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate start = new Coordinate(r, c);
        queue.add(start);
        visited[r][c] = true;
        int sum = map[r][c];
        int count = 1;

        List<Coordinate> list = new ArrayList<>();
        list.add(start);
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (isAvailable(nextR, nextC) && !visited[nextR][nextC] && canOpenLine(map[curR][curC], map[nextR][nextC])) {
                    Coordinate next = new Coordinate(nextR, nextC);
                    queue.add(next);
                    list.add(next);
                    visited[nextR][nextC] = true;
                    sum += map[nextR][nextC];
                    count++;
                }
            }
        }

        for (Coordinate coordinate : list) {
            map[coordinate.getR()][coordinate.getC()] = sum / count;
        }

        return count == 1 ? 0 : count;
    }

    private static boolean canOpenLine(int cur, int next) {
        return Math.abs(next - cur) >= L && Math.abs(next - cur) <= R;
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

    private static class Coordinate {
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
}