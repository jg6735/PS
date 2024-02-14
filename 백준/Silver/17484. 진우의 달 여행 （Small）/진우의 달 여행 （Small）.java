import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {1, 1, 1};
    private static final int[] DC = {-1, 0, 1};

    private static int N, M, answer = Integer.MAX_VALUE;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int c = 0; c < M; c++) {
            for (int d = 0; d < 3; d++) {
                search(0, c, d, map[0][c]);
            }
        }
    }

    private static void search(int r, int c, int d, int sum) {
        if (r == N - 1) {
            answer = Math.min(sum, answer);
            return;
        }

        for (int nextD = 0; nextD < 3; nextD++) {
            if (d == nextD) {
                continue;
            }

            int nextR = r + DR[nextD];
            int nextC = c + DC[nextD];
            if (nextC >= 0 && nextC < M && nextR < N) {
                search(nextR, nextC, nextD, sum + map[nextR][nextC]);
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}