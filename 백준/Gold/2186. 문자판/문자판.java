import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static char[][] board;
    private static int[][][] memo;
    private static int N, M, K, answer;
    private static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int r = 0; r < N; r++) {
            board[r] = in.readLine().toCharArray();
        }

        target = in.readLine();
        memo = new int[N][M][target.length()];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                for (int k = 0; k < target.length(); k++) {
                    memo[r][c][k] = -1;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] == target.charAt(0)) {
                    answer += dfs(r, c, 0);
                }
            }
        }

        System.out.print(answer);
    }

    private static int dfs(int r, int c, int depth) {
        if (depth == target.length() - 1) {
            return 1;
        }

        if (memo[r][c][depth] != -1) {
            return memo[r][c][depth];
        }

        memo[r][c][depth] = 0;
        for (int d = 0; d < 4; d++) {
            for (int k = 1; k <= K; k++) {
                int nextR = r + DR[d] * k;
                int nextC = c + DC[d] * k;
                if (isIn(nextR, nextC) && board[nextR][nextC] == target.charAt(depth + 1)) {
                    memo[r][c][depth] += dfs(nextR, nextC, depth + 1);
                }
            }
        }

        return memo[r][c][depth];
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}