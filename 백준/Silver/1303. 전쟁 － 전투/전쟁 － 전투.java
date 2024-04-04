import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, M, blue, white;
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
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c]) {
                    bfs(r, c);
                }
            }
        }
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curR = cur[0];
            int curC = cur[1];
            char color = map[cur[0]][cur[1]];

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    continue;
                }

                if (!visited[nextR][nextC] && map[nextR][nextC] == color) {
                    queue.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                    count++;
                }
            }
        }

        if (map[r][c] == 'W') {
            white += count * count;
        } else {
            blue += count * count;
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        visited = new boolean[M][N];
        for (int r = 0; r < M; r++) {
            String input = in.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = input.charAt(c);
            }
        }
    }

    private static void print() throws IOException {
        builder.append(white).append(" ").append(blue);
        out.write(builder.toString());
        out.flush();
    }
}