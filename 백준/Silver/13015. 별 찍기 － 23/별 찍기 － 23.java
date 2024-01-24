import java.io.*;

public class Main {

    private static int N;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int rowLength = N * 2 - 1;
        int blank = N - 2;
        for (int i = 0; i < rowLength; i++) {
            if (i == 0 || i == rowLength - 1) {
                topAndBottom();
            } else if (i == N - 1) {
                center(i, blank);
            } else {
                middle(i, blank);
            }
        }
    }

    private static void middle(int row, int blank) {
        builder.append(" ".repeat(Math.abs(Math.abs(N - row - 1) - N + 1)))
                .append("*")
                .append(" ".repeat(blank))
                .append("*")
                .append(" ".repeat(Math.max((Math.abs(N - row - 1)) * 2 - 1, 0)))
                .append("*")
                .append(" ".repeat(blank))
                .append("*")
                .append("\n");
    }

    private static void center(int row, int blank) {
        builder.append(" ".repeat(row))
                .append("*")
                .append(" ".repeat(blank))
                .append("*")
                .append(" ".repeat(blank))
                .append("*")
                .append("\n");
    }

    private static void topAndBottom() {
        builder.append("*".repeat(N))
                .append(" ".repeat(N * 2 - 3))
                .append("*".repeat(N))
                .append("\n");
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        N = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}