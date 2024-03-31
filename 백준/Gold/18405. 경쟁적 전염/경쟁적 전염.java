import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private static int N, K, answer;
    private static int S, X, Y;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Coordinate> queue;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int number = cur.getNumber();
            int time = cur.getTime();

            if (time > S) {
                break;
            }

            if (curR == X - 1 && curC == Y - 1 && map[curR][curC] != 0) {
                answer = number;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canSpread(nextR, nextC)) {
                    continue;
                }

                if (!visited[nextR][nextC] && map[nextR][nextC] == 0) {
                    queue.add(new Coordinate(nextR, nextC, number, time + 1));
                    map[nextR][nextC] = number;
                    visited[nextR][nextC] = true;
                }
            }
        }
    }

    private static boolean canSpread(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getTime() == o2.getTime()) {
                return o1.getNumber() - o2.getNumber();
            }

            return o1.getTime() - o2.getTime();
        });

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] != 0) {
                    queue.add(new Coordinate(r, c, map[r][c], 0));
                    visited[r][c] = true;
                }
            }
        }

        st = new StringTokenizer(in.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}

class Coordinate {
    private final int r;
    private final int c;
    private final int number;
    private final int time;

    public Coordinate(int r, int c, int number, int time) {
        this.r = r;
        this.c = c;
        this.number = number;
        this.time = time;
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

    public int getTime() {
        return time;
    }
}