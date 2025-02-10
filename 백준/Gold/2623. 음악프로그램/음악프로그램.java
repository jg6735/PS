import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<List<Integer>> graph;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int total = Integer.parseInt(st.nextToken());
            int[] orders = new int[total];
            for (int j = 0; j < total; j++) {
                orders[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < total - 1; j++) {
                for (int k = j + 1; k < total; k++) {
                    graph.get(orders[j]).add(orders[k]);
                    inDegree[orders[k]]++;
                }
            }
        }

        getOrders();
    }

    static void getOrders() {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }

        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (!deque.isEmpty()) {
            int node = deque.poll();
            count++;
            builder.append(node).append("\n");
            for (int next : graph.get(node)) {
                inDegree[next]--;

                if (inDegree[next] == 0) {
                    deque.add(next);
                }
            }
        }

        System.out.print(count != N ? 0 : builder);
    }
}