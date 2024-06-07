import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, H, answer;
    private static int[][] ladder;
    private static boolean isFinished;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int total = 0;
        for (int c = 1; c < N; c++) {
            int cnt = 0;
            for (int r = 1; r <= H; r++) {
                if (ladder[r][c] == 1) {
                    cnt++;
                }
            }

            if (cnt % 2 == 1) {
                total++;
            }
        }

        if (total >= 4) {
            answer = -1;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (dfs(0, 1, 1, i)) {
                answer = i;
                return;
            }
        }

        answer = -1;
    }

    private static boolean dfs(int cnt, int startR, int startC, int total) {
        if (cnt == total) {
            return checkLadder();
        }

        for (int r = startR; r <= H; r++) {
            int c = 1;
            if (r == startR) {
                c = startC;
            }

            while (c < N) {
                if (ladder[r][c] == 0 && ladder[r][c + 1] == 0) {
                    ladder[r][c] = 1;
                    ladder[r][c + 1] = -1;
                    boolean result = dfs(cnt + 1, r, c + 1, total);
                    ladder[r][c] = 0;
                    ladder[r][c + 1] = 0;

                    if (result) {
                        return true;
                    }
                }

                c++;
            }
        }

        return false;
    }

    private static boolean checkLadder() {
        for (int c = 1; c <= N; c++) {
            int curC = c;
            for (int r = 1; r <= H; r++) {
                curC += ladder[r][curC];
            }

            if (curC != c) {
                return false;
            }
        }

        return true;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladder = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = 1;
            ladder[a][b + 1] = -1;
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}