import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] inDegree;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder();

        while (T-- > 0) {
            n = Integer.parseInt(in.readLine());
            inDegree = new int[n + 1];
            int[] lastRank = new int[n + 1];
            int[] position = new int[n + 1];
            adj = new boolean[n + 1][n + 1];

            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 1; i <= n; i++) {
                lastRank[i] = Integer.parseInt(st.nextToken());
                position[lastRank[i]] = i;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    adj[lastRank[i]][lastRank[j]] = true;
                    inDegree[lastRank[j]]++;
                }
            }

            m = Integer.parseInt(in.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (adj[a][b]) {
                    adj[a][b] = false;
                    adj[b][a] = true;
                    inDegree[b]--;
                    inDegree[a]++;
                } else {
                    adj[b][a] = false;
                    adj[a][b] = true;
                    inDegree[a]--;
                    inDegree[b]++;
                }
            }

            String result = getRank();
            builder.append(result).append("\n");
        }

        System.out.print(builder);
    }

    static String getRank() {
        StringBuilder builder = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                return "IMPOSSIBLE";
            }

            if (queue.size() > 1) {
                return "?";
            }

            int cur = queue.poll();
            result.add(cur);
            for (int j = 1; j <= n; j++) {
                if (adj[cur][j]) {
                    inDegree[j]--;
                    if (inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }

        for (int num : result) {
            builder.append(num).append(" ");
        }

        return builder.toString().trim();
    }
}