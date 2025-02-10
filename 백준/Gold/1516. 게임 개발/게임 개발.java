import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] buildTimes, inDegree;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        inDegree = new int[N + 1];
        buildTimes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            buildTimes[i] = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                if (input == -1) {
                    break;
                }

                graph.get(input).add(i);
                inDegree[i]++;
            }
        }

        int[] buildTimeResult = getMinimumBuildTimes();
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            builder.append(buildTimeResult[i]).append("\n");
        }

        System.out.print(builder);
    }

    static int[] getMinimumBuildTimes() {
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                dp[i] = buildTimes[i];
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                inDegree[next]--;
                dp[next] = Math.max(dp[next], dp[node] + buildTimes[next]);
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return dp;
    }
}