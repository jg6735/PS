import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, answer;
    private static int[][] intMap;
    private static boolean[][] checked;
    private static List<Coordinate> list;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        setMap();
        search();
    }

    private static void search() {
        for (int i = 0; i < list.size() - 1; i++) {
            Coordinate cur = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                Coordinate next = list.get(j);

                if (cur.getNumber() != next.getNumber()) {
                    answer = Math.min(getDistance(cur, next), answer);
                }
            }
        }
    }

    private static int getDistance(Coordinate cur, Coordinate next) {
        return Math.abs(cur.getR() - next.getR()) + Math.abs(cur.getC() - next.getC()) - 1;
    }

    private static void setMap() {
        int number = 1;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (intMap[r][c] != 0 && !checked[r][c]) {
                    searchMap(r, c, number++);
                }
            }
        }
    }

    private static void searchMap(int r, int c, int number) {
        Queue<Coordinate> queue = new LinkedList<>();
        Coordinate start = new Coordinate(r, c, number, false);
        queue.add(start);
        checked[r][c] = true;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    continue;
                }

                if (!cur.isOut() && intMap[curR][curC] == 1 && intMap[nextR][nextC] == 0) {
                    cur.setOut(true);
                    list.add(cur);
                }

                if (!checked[nextR][nextC] && intMap[nextR][nextC] == intMap[r][c]) {
                    Coordinate next = new Coordinate(nextR, nextC, number, false);
                    queue.add(next);
                    checked[nextR][nextC] = true;
                }
            }
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        intMap = new int[N][N];
        checked = new boolean[N][N];
        list = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                intMap[r][c] = Integer.parseInt(st.nextToken());
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
        private int number;
        private boolean isOut;

        public Coordinate(int r, int c, int number, boolean isOut) {
            this.r = r;
            this.c = c;
            this.number = number;
            this.isOut = isOut;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getNumber() {
            return number;
        }

        public boolean isOut() {
            return isOut;
        }

        public void setOut(boolean out) {
            isOut = out;
        }
    }
}