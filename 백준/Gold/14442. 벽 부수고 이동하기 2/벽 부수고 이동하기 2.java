import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] DR = {-1, 0, 1, 0};
    static final int[] DC = {0, 1, 0, -1};

    static int N, M, K, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        answer = -1;
        for (int r = 0; r < N; r++) {
            String input = in.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = input.charAt(c) - '0';
            }
        }

        bfs(new Coordinate(0, 0, 1, K));
        System.out.print(answer);
    }

    static void bfs(Coordinate start) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][K + 1];
        queue.add(start);

        Coordinate cur;
        int curR, curC, curDistance, destroyed, nextR, nextC;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curR = cur.getR();
            curC = cur.getC();
            curDistance = cur.getDistance();
            destroyed = cur.getDestroyed();

            if (curR == N - 1 && curC == M - 1) {
                answer = curDistance;
                return;
            }

            for (int d = 0; d < 4; d++) {
                nextR = curR + DR[d];
                nextC = curC + DC[d];

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
                    continue;
                }

                if (visited[nextR][nextC][destroyed]) {
                    continue;
                }

                if (map[nextR][nextC] == 0) {
                    visited[nextR][nextC][destroyed] = true;
                    queue.add(new Coordinate(nextR, nextC, curDistance + 1, destroyed));
                } else {
                    if (destroyed > 0) {
                        visited[nextR][nextC][destroyed] = true;
                        queue.add(new Coordinate(nextR, nextC, curDistance + 1, destroyed - 1));
                    }
                }
            }
        }
    }
}

class Coordinate {
    private int r;
    private int c;
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