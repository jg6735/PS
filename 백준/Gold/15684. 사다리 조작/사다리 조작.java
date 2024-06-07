import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, H, answer;
    private static boolean[][] ladder;
    private static boolean isFinished;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i <= 3; i++) {
            answer = i;
            dfs(1, 0);
            if (isFinished) {
                return;
            }
        }
    }

    private static void dfs(int idx, int cnt) {
        if (isFinished) {
            return;
        }

        if (answer == cnt) {
            if (checkLadder()) {
                isFinished = true;
            }

            return;
        }

        for (int r = idx; r <= H; r++) {
            for (int c = 1; c < N; c++) {
                if (ladder[r][c] || ladder[r][c - 1]) {
                    continue;
                }

                ladder[r][c] = true;
                dfs(r, cnt + 1);
                ladder[r][c] = false;
            }
        }
    }

    private static boolean checkLadder() {
        for (int c = 1; c <= N; c++) {
            int curC = c;
            for (int r = 1; r <= H; r++) {
                if (ladder[r][curC]) {
                    curC++;
                } else if (ladder[r][curC - 1]) {
                    curC--;
                }
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
        ladder = new boolean[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladder[a][b] = true;
        }
    }

    private static void print() throws IOException {
        answer = isFinished ? answer : -1;
        out.write(Integer.toString(answer));
        out.flush();
    }
}