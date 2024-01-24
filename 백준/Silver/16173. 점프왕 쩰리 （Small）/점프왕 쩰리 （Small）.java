import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {1, 0};
    private static final int[] DY = {0, 1};
    private static final String CLEAR = "HaruHaru";
    private static final String IMPOSSIBLE = "Hing";

    private static int N;
    private static String answer;
    private static Coordinate[][] map;
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
        queue.add(map[0][0]);
        visited[0][0] = true;

        Coordinate cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur.getNumber() == -1) {
                answer = CLEAR;
                return;
            }

            for (int d = 0; d < 2; d++) {
                int nextX = cur.getX() + DX[d] * cur.getNumber();
                int nextY = cur.getY() + DY[d] * cur.getNumber();

                if (isAvailable(nextX, nextY) && !visited[nextY][nextX]) {
                    queue.add(new Coordinate(nextX, nextY, map[nextY][nextX].getNumber()));
                    visited[nextY][nextX] = true;
                }
            }
        }

        answer = IMPOSSIBLE;
    }

    private static boolean isAvailable(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        map = new Coordinate[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = new Coordinate(i, j, Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void print() throws IOException {
        out.write(answer);
        out.flush();
    }

    private static class Coordinate {
        private final int x;
        private final int y;
        private final int number;

        public Coordinate(int x, int y, int number) {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getNumber() {
            return number;
        }
    }
}