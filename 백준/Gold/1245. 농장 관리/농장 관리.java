import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] DC = {-1, -1, 0, 1, 1, 1, 0, -1};

    private static int[][] map;
    private static boolean[][] visited;
    private static int N, M, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c] && map[r][c] != 0) {
                    if (bfs(r, c)) {
                        answer++;
                    }
                }
            }
        }

        System.out.print(answer);
    }

    private static boolean bfs(int startR, int startC) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startR, startC});
        visited[startR][startC] = true;
        int height = map[startR][startC];
        boolean flag = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 8; d++) {
                int nextR = r + DR[d];
                int nextC = c + DC[d];
                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) {
                    continue;
                }

                if (map[nextR][nextC] > height) {
                    flag = false;
                }

                if (!visited[nextR][nextC] && map[nextR][nextC] == height) {
                    visited[nextR][nextC] = true;
                    queue.add(new int[]{nextR, nextC});
                }
            }
        }

        return flag;
    }
}