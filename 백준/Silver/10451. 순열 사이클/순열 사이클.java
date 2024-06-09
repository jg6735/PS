import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        StringTokenizer st;
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            int[] parents = new int[N + 1];
            cycle = 0;

            for (int i = 1; i <= N; i++) {
                parents[i] = i;
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= N; i++) {
                int a = i;
                int b = Integer.parseInt(st.nextToken());
                union(parents, a, b);
            }

            builder.append(cycle).append("\n");
        }

        System.out.print(builder);
    }

    static void dfs(int[] arr, boolean[] visited, int i) {
        visited[i] = true;

        int next = arr[i];
        if (!visited[next]) {
            dfs(arr, visited, arr[i]);
        }
    }

    static void union(int[] parents, int x, int y) {
        x = find(parents, x);
        y = find(parents, y);

        if (x == y) {
            cycle++;
        } else if (x > y) {
            parents[x] = y;
        } else {
            parents[y] = x;
        }
    }

    static int find(int[] parents, int x) {
        if (parents[x] == x) {
            return x;
        }

        return find(parents, parents[x]);
    }
}