import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<List<Node>> graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new Node(B, C));
            graph.get(B).add(new Node(A, C));
        }

        System.out.print(getMinimumCost());
    }

    static int getMinimumCost() {
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        pq.add(new Node(1, 0));
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[1] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.getId();
            int cost = cur.getCost();

            for (Node neighbor : graph.get(node)) {
                if (cost + neighbor.getCost() < costs[neighbor.getId()]) {
                    costs[neighbor.getId()] = cost + neighbor.getCost();
                    pq.add(new Node(neighbor.getId(), cost + neighbor.getCost()));
                }
            }
        }

        return costs[N];
    }
}

class Node {

    private int id;
    private int cost;

    public Node(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }
}