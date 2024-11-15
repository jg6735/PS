import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] ladderInfo, snakeInfo;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladderInfo = new int[101];
        snakeInfo = new int[101];
        visited = new boolean[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            ladderInfo[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            snakeInfo[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        System.out.print(bfs(1));
    }

    private static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { start, 0 });
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int count = cur[1];

            if (pos == 100) {
                return count;
            }

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100) {
                    continue;
                }

                if (!visited[next]) {
                    if (ladderInfo[next] != 0) {
                        visited[ladderInfo[next]] = true;
                        queue.add(new int[]{ladderInfo[next], count + 1});
                    } else if (snakeInfo[next] != 0) {
                        visited[snakeInfo[next]] = true;
                        queue.add(new int[]{snakeInfo[next], count + 1});
                    } else {
                        visited[next] = true;
                        queue.add(new int[]{next, count + 1});
                    }
                }
            }
        }

        return -1;
    }
}