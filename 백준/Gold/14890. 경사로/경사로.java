import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, L, answer;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            search(0, i, 0, new boolean[N]); // 상하 탐색
            search(i, 0, 1, new boolean[N]); // 좌우 탐색
        }
    }

    private static void search(int row, int col, int dir, boolean[] visited) {
        for (int i = 0; i < N - 1; i++) {
            int diff;
            if (dir == 0) {
                diff = map[i][col] - map[i + 1][col];
            } else {
                diff = map[row][i] - map[row][i + 1];
            }

            if (diff > 1 || diff < -1) {
                return;
            } else if (diff == -1) {
                for (int j = 0; j < L; j++) {
                    if (i < j || visited[i - j]) {
                        return;
                    }

                    // 상하 탐색
                    if (dir == 0 && map[i][col] != map[i - j][col]) {
                        return;
                    }

                    // 좌우 탐색
                    if (dir == 1 && map[row][i] != map[row][i - j]) {
                        return;
                    }

                    visited[i - j] = true;
                }
            } else if (diff == 1) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || visited[i + j]) {
                        return;
                    }

                    // 상하 탐색
                    if (dir == 0 && map[i][col] != map[i + j][col] + 1) {
                        return;
                    }

                    // 좌우 탐색
                    if (dir == 1 && map[row][i] != map[row][i + j] + 1) {
                        return;
                    }

                    visited[i + j] = true;
                }
            }
        }

        answer++;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

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