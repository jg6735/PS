import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N;
    private static char[][] map;
    private static boolean[][] visited;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        List<Integer> list = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && map[r][c] != '0') {
                    list.add(search(r, c));
                }
            }
        }

        builder.append(list.size()).append("\n");
        Collections.sort(list);
        for (int number : list) {
            builder.append(number).append("\n");
        }
    }

    private static int search(int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c));
        visited[r][c] = true;

        Coordinate cur;
        int curR, curC, nextR, nextC, count = 1;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curR = cur.getR();
            curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                nextR = curR + DR[d];
                nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    continue;
                }

                if (!visited[nextR][nextC] && map[curR][curC] == map[nextR][nextC]) {
                    queue.add(new Coordinate(nextR, nextC));
                    count++;
                    visited[nextR][nextC] = true;
                }
            }
        }

        return count;
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            String input = in.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = input.charAt(c);
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
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