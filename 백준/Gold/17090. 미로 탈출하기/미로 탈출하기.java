import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};
    private static final char[] DIR = {'U', 'R', 'D', 'L'};

    private static char[][] map;
    private static boolean[][] visited;
    private static boolean[][] memo;
    private static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        memo = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            map[r] = in.readLine().toCharArray();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (dfs(r, c)) {
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }

    private static boolean dfs(int r, int c) {
        if (!isIn(r, c)) {
            return true;
        }

        if (visited[r][c]) {
            return memo[r][c];
        }

        visited[r][c] = true;
        int direction = getDirection(map[r][c]);
        int nextR = r + DR[direction];
        int nextC = c + DC[direction];

        if (dfs(nextR, nextC)) {
            memo[r][c] = true;
        }

        return memo[r][c];
    }

    private static int getDirection(char ch) {
        for (int d = 0; d < DIR.length; d++) {
            if (DIR[d] == ch) {
                return d;
            }
        }
        
        return -1;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}