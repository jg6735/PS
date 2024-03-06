import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static int N;
    private static Queue<Integer> queue;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (N-- > 0) {
            int x = Integer.parseInt(in.readLine());
            if (x != 0) {
                queue.add(x);
            } else {
                if (!queue.isEmpty()) {
                    builder.append(queue.poll());
                } else {
                    builder.append(0);
                }

                builder.append("\n");
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        N = Integer.parseInt(in.readLine());
        queue = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 - o2;
            }

            return abs1 - abs2;
        });
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}