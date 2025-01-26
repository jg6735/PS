import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] buildTimes = new int[N + 1];
            int[] inDegree = new int[N + 1];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= N; i++) {
                buildTimes[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(in.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph.get(X).add(Y);
                inDegree[Y]++;
            }

            int W = Integer.parseInt(in.readLine());
            int minTime = getMinTime(graph, buildTimes, inDegree, W, N);
            builder.append(minTime).append("\n");
        }

        System.out.print(builder);
    }

    private static int getMinTime(List<List<Integer>> graph, int[] buildTimes, int[] inDegree,
        int target, int N) {
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            // 진입 차수 : 0 -> 바로 지을 수 있는 건물
            if (inDegree[i] == 0) {
                queue.add(i);
                dp[i] = buildTimes[i];
            }
        }

        // 위상 정렬
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                inDegree[next]--;

                // dp[next] : 현재까지 계산된 최소 건설 시간
                dp[next] = Math.max(dp[next], dp[node] + buildTimes[next]);
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return dp[target];
    }
}