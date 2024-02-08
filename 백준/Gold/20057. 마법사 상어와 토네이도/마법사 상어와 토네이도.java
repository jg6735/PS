import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {-1, 0, 1, 0};
    private static final int[][] SPREAD_ROW = {
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0},
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1}
    };
    private static final int[][] SPREAD_COL = {
            {1, 1, 0, 0, 0, 0, -1, -1, -2, -1},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2, 1},
            {-1, 1, -2, 2, -1, 1, -1, 1, 0, 0}
    };

    private static final int[] RATIO = {1, 1, 2, 2, 7, 7, 10, 10, 5, 0};

    private static int N, answer;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        tornado(N / 2, N / 2);
    }

    private static void tornado(int r, int c) {
        int nextR = r;
        int nextC = c;
        int cnt = 0;
        int max = 1;
        int dir = 0;

        while (true) {
            for (int i = 0; i < max; i++) {
                nextR += DR[dir];
                nextC += DC[dir];

                if (map[nextR][nextC] > 0) {
                    spread(nextR, nextC, dir);
                }

                if (nextR == 0 && nextC == 0) {
                    return;
                }
            }

            if (++cnt == 2) {
                max++;
                cnt = 0;
            }

            dir = ++dir % 4;
        }
    }

    private static void spread(int r, int c, int dir) {
        int sand = map[r][c];
        map[r][c] = 0;
        int totalMovedSand = 0;

        for (int d = 0; d < 9; d++) {
            int nextR = r + SPREAD_ROW[dir][d];
            int nextC = c + SPREAD_COL[dir][d];
            int spreadSand = sand * RATIO[d] / 100;

            if (isAvailable(nextR, nextC)) {
                map[nextR][nextC] += spreadSand;
            } else {
                answer += spreadSand;
            }

            totalMovedSand += spreadSand;
        }

        int aR = r + SPREAD_ROW[dir][9];
        int aC = c + SPREAD_COL[dir][9];
        int remainSand = sand - totalMovedSand;
        if (isAvailable(aR, aC)) {
            map[aR][aC] += remainSand;
        } else {
            answer += remainSand;
        }
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}