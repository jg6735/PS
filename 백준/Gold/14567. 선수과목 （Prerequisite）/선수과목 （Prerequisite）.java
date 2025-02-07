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
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            inDegree[B]++;
        }

        int[] result = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                result[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : graph.get(node)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                    result[next] = result[node] + 1;
                }

            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            builder.append(result[i]).append(" ");
        }

        System.out.print(builder);
    }
}