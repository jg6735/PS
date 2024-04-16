import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static final int R = 12;
    private static final int C = 6;
    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int answer;
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
        while (true) {
            int count = 0;
            visited = new boolean[R][C];
            for (int r = R - 1; r >= 0; r--) {
                for (int c = 0; c < C; c++) {
                    if (!visited[r][c] && map[r][c] != '.') {
                        count += search(r, c);
                    }
                }
            }

            if (count == 0) {
                break;
            }
            
            answer++;
            drop();
        }
    }

    private static int search(int r, int c) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c));
        visited[r][c] = true;

        List<Coordinate> list = new ArrayList<>();
        int count = 1;
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            char color = map[curR][curC];
            list.add(cur);

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    continue;
                }

                if (!visited[nextR][nextC] && map[nextR][nextC] == color) {
                    queue.add(new Coordinate(nextR, nextC));
                    visited[nextR][nextC] = true;
                    count++;
                }
            }
        }

        if (count >= 4) {
            for (Coordinate cur : list) {
                map[cur.getR()][cur.getC()] = '.';
            }

            return 1;
        }

        return 0;
    }

    private static void drop() {
        for (int r = R - 1; r > 0; r--) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == '.') {
                    for (int nextR = r - 1; nextR >= 0; nextR--) {
                        if (map[nextR][c] != '.') {
                            map[r][c] = map[nextR][c];
                            map[nextR][c] = '.';
                            break;
                        }
                    }
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
        map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String input = in.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}

class Coordinate {
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