import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final String CORRECT = "YES";
    private static final String INCORRECT = "NO";
    private static boolean check = false;
    private static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder builder = new StringBuilder();
        while (K-- > 0) {
            st = new StringTokenizer(in.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            check = true;

            for (int i = 0; i < V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(in.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                graph.get(u).add(v);
                graph.get(v).add(u);
            }

            int[] arr = new int[V];
            for (int i = 0; i < V; i++) {
                if (arr[i] == 0) {
                    if (!dfs(arr, i, 1)) {
                        check = false;
                        break;
                    }
                }
            }

            builder.append(check ? CORRECT : INCORRECT).append("\n");
        }

        System.out.print(builder);
    }

    private static boolean dfs(int[] arr, int node, int color) {
        arr[node] = color;
        for (int next : graph.get(node)) {
            if (arr[next] == 0) {
                if (!dfs(arr, next, -color)) {
                    return false;
                }
            } else if (arr[next] == arr[node]) {
                return false;
            }
        }

        return true;
    }
}