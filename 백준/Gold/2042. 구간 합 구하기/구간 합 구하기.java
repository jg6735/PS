import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(in.readLine());
        }

        SegmentTree segmentTree = new SegmentTree(arr);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                segmentTree.update(b - 1, c);
            } else {
                builder.append(segmentTree.query(b - 1, (int) c - 1)).append("\n");
            }
        }

        System.out.print(builder);
    }
}

class SegmentTree {
    private long[] tree;
    private int n;

    public SegmentTree(long[] arr) {
        this.n = arr.length;
        this.tree = new long[n * 4];
        build(arr, 0, n - 1, 1);
    }

    private void build(long[] arr, int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, start, mid, node * 2);
        build(arr, mid + 1, end, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public long query(int left, int right) {
        return query(0, n - 1, 1, left, right);
    }

    private long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        long leftSum = query(start, mid, node * 2, left, right);
        long rightSum = query(mid + 1, end, node * 2 + 1, left, right);
        return leftSum + rightSum;
    }

    public void update(int index, long next) {
        update(0, n - 1, 1, index, next);
    }

    private void update(int start, int end, int node, int index, long next) {
        if (start == end) {
            tree[node] = next;
            return;
        }

        int mid = (start + end) / 2;
        if (index <= mid) {
            update(start, mid, node * 2, index, next);
        } else {
            update(mid + 1, end, node * 2 + 1, index, next);
        }

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}