import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0, 0, 0};
    private static final int[] DC = {0, 1, 0, -1, 0, 0};
    private static final int[] DL = {0, 0, 0, 0, 1, -1};

    private static int L, R, C, answer;
    private static char[][][] map;
    private static boolean[][][] visited;
    private static Coordinate start;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (true) {
            String input = in.readLine();
            if (input.charAt(0) == '0') {
                break;
            }

            setBuilding(input);
            canExit();
        }
    }

    private static void setBuilding(String input) throws IOException {
        StringTokenizer st = new StringTokenizer(input);
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[L][R][C];
        visited = new boolean[L][R][C];
        answer = 0;
        for (int l = 0; l < L; l++) {
            for (int r = 0; r < R; r++) {
                input = in.readLine();
                for (int c = 0; c < C; c++) {
                    map[l][r][c] = input.charAt(c);
                    if (map[l][r][c] == 'S') {
                        start = new Coordinate(l, r, c, 0);
                    }
                }
            }

            in.readLine();
        }

        if (canExit()) {
            builder.append("Escaped in ").append(answer).append(" minute(s).");
        } else {
            builder.append("Trapped!");
        }

        builder.append("\n");
    }

    private static boolean canExit() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getL()][start.getR()][start.getC()] = true;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curL = cur.getL();
            int curR = cur.getR();
            int curC = cur.getC();
            int curCount = cur.getCount();

            if (map[curL][curR][curC] == 'E') {
                answer = curCount;
                return true;
            }

            for (int d = 0; d < 6; d++) {
                int nextL = curL + DL[d];
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (canVisit(nextL, nextR, nextC) && !visited[nextL][nextR][nextC]) {
                    queue.add(new Coordinate(nextL, nextR, nextC, curCount + 1));
                    visited[nextL][nextR][nextC] = true;
                }
            }
        }

        return false;
    }

    private static boolean canVisit(int l, int r, int c) {
        return l >= 0 && r >= 0 && c >= 0 && l < L && r < R && c < C && (map[l][r][c] == '.' || map[l][r][c] == 'E');
    }

    private static void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }

    private static class Coordinate {
        private int l;
        private int r;
        private int c;
        private int count;

        public Coordinate(int l, int r, int c, int count) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.count = count;
        }

        public int getL() {
            return l;
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