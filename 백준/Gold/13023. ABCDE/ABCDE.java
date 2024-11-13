import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, answer;
    private static List<List<Integer>> graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false);
            dfs(i, 0);
            
            if (answer == 1) {
                System.out.print(answer);
                return;
            }
        }

        System.out.print(answer);
    }

    private static void dfs(int node, int depth) {
        if (depth == 4) {
            answer = 1;
            return;
        }

        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }

        visited[node] = false;
    }
}