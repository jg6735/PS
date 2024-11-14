import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<List<Integer>> tree;
    private static int N, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        int[] parents = new int[N];
        tree = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        int root = -1;
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            parents[i] = Integer.parseInt(st.nextToken());
            if (parents[i] == -1) {
                root = i;
            } else {
                tree.get(parents[i]).add(i);
            }
        }

        int removeNode = Integer.parseInt(in.readLine());
        if (removeNode == root) {
            System.out.print(0);
        } else {
            dfs(root, removeNode);
            System.out.print(answer);
        }
    }

    private static void dfs(int node, int removeNode) {
        if (node == removeNode) {
            return;
        }

        if (tree.get(node).isEmpty()) {
            answer++;
            return;
        }

        boolean hasChild = false;
        for (int childNode : tree.get(node)) {
            if (childNode != removeNode) {
                hasChild = true;
                dfs(childNode, removeNode);
            }
        }

        if (!hasChild) {
            answer++;
        }
    }
}