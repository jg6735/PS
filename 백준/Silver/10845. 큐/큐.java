import java.io.*;
import java.util.LinkedList;

public class Main {

    private static LinkedList<Integer> queue;
    private static int N;

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
            String cmd = in.readLine();

            if (cmd.contains("push")) {
                queue.add(Integer.parseInt(cmd.substring(5)));
            } else if (cmd.equals("size")) {
                builder.append(queue.size()).append("\n");
            } else if (cmd.equals("pop")) {
                builder.append(!queue.isEmpty() ? queue.poll() : "-1").append("\n");
            } else if (cmd.equals("front")) {
                builder.append(!queue.isEmpty() ? queue.get(0) : "-1").append("\n");
            } else if (cmd.equals("back")) {
                builder.append(!queue.isEmpty() ? queue.get(queue.size() - 1) : "-1").append("\n");
            } else if (cmd.equals("empty")) {
                builder.append(queue.isEmpty() ? "1" : "0").append("\n");
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        queue = new LinkedList<>();
        N = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}