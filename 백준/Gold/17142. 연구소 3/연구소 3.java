import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, M, emptyCount, answer;
    private static int[][] map;
    private static List<Coordinate> viruses;
    private static Coordinate[] isSelected;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        if (emptyCount == 0) {
            answer = 0;
            return;
        }

        search(0, 0);
        answer = answer != Integer.MAX_VALUE ? answer : -1;
    }

    private static void search(int cnt, int start) {
        if (cnt == M) {
            int total = emptyCount;
            bfs(isSelected, total);
            return;
        }

        for (int i = start; i < viruses.size(); i++) {
            isSelected[cnt] = viruses.get(i);
            search(cnt + 1, i + 1);
        }
    }

    private static void bfs(Coordinate[] viruses, int total) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        for (Coordinate virus : viruses) {
            queue.add(virus);
            visited[virus.getR()][virus.getC()] = true;
        }

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int curDist = cur.getDist();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canSpread(nextR, nextC)) {
                    continue;
                }

                if (map[nextR][nextC] == 1) {
                    continue;
                }

                if (!visited[nextR][nextC]) {
                    if (map[nextR][nextC] == 0 && --total == 0) {
                        answer = Math.min(answer, curDist + 1);
                        return;
                    }

                    visited[nextR][nextC] = true;
                    queue.add(new Coordinate(nextR, nextC, curDist + 1));
                }
            }
        }
    }

    private static boolean canSpread(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        isSelected = new Coordinate[M];
        viruses = new ArrayList<>();
        answer = Integer.MAX_VALUE;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == 2) {
                    viruses.add(new Coordinate(r, c, 0));
                } else if (map[r][c] == 0) {
                    emptyCount++;
                }
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
    private final int dist;

    public Coordinate(int r, int c, int dist) {
        this.r = r;
        this.c = c;
        this.dist = dist;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getDist() {
        return dist;
    }
}