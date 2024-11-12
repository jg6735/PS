import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n, far, answer;
    private static List<Node>[] tree;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        tree = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(in.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }
        
        visited = new boolean[n + 1];
        dfs(1, 0);
        
        visited = new boolean[n + 1];
        dfs(far, 0);

        System.out.println(answer);
    }
    
    private static void dfs(int node, int distance) {
        visited[node] = true;
        if (distance > answer) {
            answer = distance;
            far = node;
        }

        for (Node n : tree[node]) {
            if (!visited[n.next]) {
                dfs(n.next, distance + n.weight);
            }
        }
    }
}

class Node {

    int next;
    int weight;

    Node(int next, int weight) {
        this.next = next;
        this.weight = weight;
    }
}