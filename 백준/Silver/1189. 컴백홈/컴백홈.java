import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static char[][] map;
    private static boolean[][] visited;
    private static int R, C, K, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            map[r] = in.readLine().toCharArray();
        }

        visited[R - 1][0] = true;
        search(R - 1, 0, 1);
        System.out.print(answer);
    }

    private static void search(int r, int c, int dist) {
        if (r == 0 && c == C - 1) {
            if (dist == K) {
                answer++;
            }

            return;
        }

        for (int d = 0; d < 4; d++) {
            int nextR = r + DR[d];
            int nextC = c + DC[d];
            if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
                continue;
            }

            if (!visited[nextR][nextC] && map[nextR][nextC] != 'T') {
                visited[nextR][nextC] = true;
                search(nextR, nextC, dist + 1);
                visited[nextR][nextC] = false;
            }
        }
    }
}