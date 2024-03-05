import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static char[][] tree;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        char root = 'A';
        preOrder(root);
        builder.append("\n");
        inOrder(root);
        builder.append("\n");
        postOrder(root);
    }

    private static void preOrder(char parent) {
        if (parent == 0) {
            return;
        }

        builder.append(parent);
        preOrder(tree[parent][0]);
        preOrder(tree[parent][1]);
    }

    private static void inOrder(char parent) {
        if (parent == 0) {
            return;
        }

        inOrder(tree[parent][0]);
        builder.append(parent);
        inOrder(tree[parent][1]);
    }

    private static void postOrder(char parent) {
        if (parent == 0) {
            return;
        }

        postOrder(tree[parent][0]);
        postOrder(tree[parent][1]);
        builder.append(parent);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        tree = new char['A' + 26][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            char parent = st.nextToken().charAt(0);
            char leftChild = st.nextToken().charAt(0);
            char rightChild = st.nextToken().charAt(0);

            if (leftChild != '.') {
                tree[parent][0] = leftChild;
            }

            if (rightChild != '.') {
                tree[parent][1] = rightChild;
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}