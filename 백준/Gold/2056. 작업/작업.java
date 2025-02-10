import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] inDegree, times;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        inDegree = new int[N + 1];
        times = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(i).add(next);
                inDegree[next]++;
            }
        }

        System.out.print(getMinimumTime());
    }

    static int getMinimumTime() {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] dp = new int[N + 1]; // dp[x] : x번 작업을 완료하기 위한 최소 시간
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
                dp[i] = times[i];
            }
        }

        while (!deque.isEmpty()) {
            int node = deque.poll();

            for (int next : graph.get(node)) {
                dp[next] = Math.max(dp[next], dp[node] + times[next]);
                if (--inDegree[next] == 0) {
                    deque.add(next);
                }
            }
        }

        int total = 0;
        for (int i = 1; i <= N; i++) {
            total = Math.max(total, dp[i]);
        }

        return total;
    }
}