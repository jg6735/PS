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
    static List<List<Node>> graph, reverseGraph;
    static int[] inDegree, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        m = Integer.parseInt(in.readLine());
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        inDegree = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, dist));
            reverseGraph.get(end).add(new Node(start, dist));
            inDegree[end]++;
        }

        st = new StringTokenizer(in.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int time = search(graph, from, to);
        int count = countPaths(reverseGraph, to);
        System.out.println(time + "\n" + count);
    }

    static int search(List<List<Node>> graph, int from, int to) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(from);
        dp[from] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node next : graph.get(cur)) {
                dp[next.getId()] = Math.max(dp[next.getId()], dp[cur] + next.getDist());
                if (--inDegree[next.getId()] == 0) {
                    queue.add(next.getId());
                }
            }
        }

        return dp[to];
    }

    static int countPaths(List<List<Node>> reverseGraph, int to) {
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        queue.add(to);
        visited[to] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Node prev : reverseGraph.get(cur)) {
                if (dp[prev.getId()] + prev.getDist() == dp[cur]) {
                    count++;
                    if (!visited[prev.getId()]) {
                        visited[prev.getId()] = true;
                        queue.add(prev.getId());
                    }
                }
            }
        }

        return count;
    }
}

class Node {

    private int id;
    private int dist;

    public Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    public int getId() {
        return id;
    }

    public int getDist() {
        return dist;
    }
}