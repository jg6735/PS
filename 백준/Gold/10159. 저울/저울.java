import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static List<Integer>[] heavyList, lightList;
    private static boolean[] visited;
    private static int heavyCount, lightCount;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        heavyList = new ArrayList[N + 1];
        lightList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            heavyList[i] = new ArrayList<>();
            lightList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int heavy = Integer.parseInt(st.nextToken());
            int light = Integer.parseInt(st.nextToken());
            heavyList[light].add(heavy);
            lightList[heavy].add(light);
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            heavyCount = 0;
            dfs(i, heavyList);

            visited = new boolean[N + 1];
            lightCount = 0;
            dfs(i, lightList);

            int answer = N - 1 - heavyCount - lightCount;
            builder.append(answer).append("\n");
        }

        System.out.print(builder);
    }

    private static void dfs(int i, List<Integer>[] list) {
        visited[i] = true;
        for (int next : list[i]) {
            if (!visited[next]) {
                if (list == heavyList) {
                    heavyCount++;
                } else {
                    lightCount++;
                }

                dfs(next, list);
            }
        }
    }
}