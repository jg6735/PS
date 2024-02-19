import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final String FAIL = "IMPOSSIBLE";
    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int T, R, C, answer;
    private static char[][] map;
    private static Queue<Coordinate> fire;
    private static Queue<Coordinate> queue;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (T-- > 0) {
            setMap();
            while (!queue.isEmpty()) {
                spreadFire();
                canExit();
            }

            if (answer == Integer.MAX_VALUE) {
                builder.append(FAIL);
            } else {
                builder.append(answer);
            }

            builder.append("\n");
        }
    }

    private static void setMap() throws IOException {
        StringTokenizer st = new StringTokenizer(in.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fire = new LinkedList<>();
        queue = new LinkedList<>();
        answer = Integer.MAX_VALUE;
        for (int r = 0; r < R; r++) {
            String input = in.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == '*') {
                    fire.add(new Coordinate(r, c, 0));
                }

                if (map[r][c] == '@') {
                    queue.add(new Coordinate(r, c, 1));
                }
            }
        }
    }

    private static void canExit() {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int curCount = cur.getCount();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    answer = Math.min(answer, curCount);
                    return;
                }

                if (map[nextR][nextC] != '#' && map[nextR][nextC] != '*' && map[nextR][nextC] != '@') {
                    queue.add(new Coordinate(nextR, nextC, curCount + 1));
                    map[nextR][nextC] = '@';
                }
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

                if (canVisit(nextR, nextC) && map[nextR][nextC] != '#' && map[nextR][nextC] != '*') {
                    fire.add(new Coordinate(nextR, nextC, 0));
                    map[nextR][nextC] = '*';
                }
            }
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        T = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }

    private static class Coordinate {
        private int r;
        private int c;
        private int count;

        public Coordinate(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getCount() {
            return count;
        }
    }
}