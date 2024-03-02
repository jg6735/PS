import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, M, answer;
    private static int[][] map;
    private static boolean[][][] visited;

    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int curDistance = cur.getDistance();
            int destroyed = cur.getDestroyed();

            if (curR == N - 1 && curC == M - 1) {
                answer = curDistance;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    continue;
                }

                if (map[nextR][nextC] == 0 && !visited[nextR][nextC][destroyed]) {
                    queue.add(new Coordinate(nextR, nextC, curDistance + 1, destroyed));
                    visited[nextR][nextC][destroyed] = true;
                } else {
                    if (destroyed == 0 && !visited[nextR][nextC][1]) {
                        queue.add(new Coordinate(nextR, nextC, curDistance + 1, 1));
                        visited[nextR][nextC][1] = true;
                    }
                }
            }
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][2];
        answer = -1;

        for (int r = 0; r < N; r++) {
            String input = in.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c) - '0';
            }
        }
    }

    private static void print() {
        System.out.println(answer);
    }

    private static class Coordinate {
        private final int r;
        private final int c;
        private int distance;
        private int destroyed;

        public Coordinate(int r, int c, int distance, int destroyed) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.destroyed = destroyed;
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

        public int getDestroyed() {
            return destroyed;
        }
    }
}