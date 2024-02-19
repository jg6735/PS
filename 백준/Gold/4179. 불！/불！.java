import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, -1, 0, 1};
    private static final String FAIL = "IMPOSSIBLE";

    private static int R, C, answer;
    private static Queue<Coordinate> fire;
    private static Queue<Coordinate> jihun;
    private static char[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        while (!jihun.isEmpty()) {
            spreadFire();
            exit();
        }
    }

    private static void exit() {
        int size = jihun.size();
        for (int i = 0; i < size; i++) {
            Coordinate cur = jihun.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int curCount = cur.getCnt();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    answer = Math.min(answer, curCount);
                    return;
                }

                if (map[nextR][nextC] != '.') {
                    continue;
                }

                jihun.add(new Coordinate(nextR, nextC, curCount + 1));
                map[nextR][nextC] = 'J';
            }
        }
    }

    private static void spreadFire() {
        int size = fire.size();
        for (int i = 0; i < size; i++) {
            Coordinate cur = fire.poll();
            int curR = cur.getR();
            int curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    continue;
                }

                if (map[nextR][nextC] == '#' || map[nextR][nextC] == 'F') {
                    continue;
                }

                fire.add(new Coordinate(nextR, nextC, -1));
                map[nextR][nextC] = 'F';
            }
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        jihun = new LinkedList<>();
        fire = new LinkedList<>();
        answer = Integer.MAX_VALUE;

        for (int r = 0; r < R; r++) {
            String input = in.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == 'J') {
                    jihun.add(new Coordinate(r, c, 1));
                }
                if (map[r][c] == 'F') {
                    fire.add(new Coordinate(r, c, -1));
                }
            }
        }
    }

    private static void print() throws IOException {
        if (answer == Integer.MAX_VALUE) {
            out.write(FAIL);
        } else {
            out.write(Integer.toString(answer));
        }

        out.flush();
    }

    private static class Coordinate {
        private int r;
        private int c;
        private int cnt;

        public Coordinate(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getCnt() {
            return cnt;
        }
    }
}