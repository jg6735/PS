import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final String FAIL = "use the stairs";

    private static int F, S, G, U, D;
    private static String answer;
    private static boolean[] visited;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        search(S);
    }

    private static void search(int start) {
        Queue<Floor> queue = new LinkedList<>();
        queue.add(new Floor(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Floor floor = queue.poll();
            int curV = floor.getV();
            int curCount = floor.getCount();
            if (curV == G) {
                answer = Integer.toString(curCount);
                return;
            }

            if (curV + U <= F && !visited[curV + U]) {
                queue.add(new Floor(curV + U, curCount + 1));
                visited[curV + U] = true;
            }

            if (curV - D >= 1 && !visited[curV - D]) {
                queue.add(new Floor(curV - D, curCount + 1));
                visited[curV - D] = true;
            }
        }

        answer = FAIL;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F + 1];
    }

    private static void print() throws IOException {
        out.write(answer);
        out.flush();
    }

    private static class Floor {
        private int v;
        private int count;

        public Floor(int v, int count) {
            this.v = v;
            this.count = count;
        }

        public int getV() {
            return v;
        }

        public int getCount() {
            return count;
        }
    }
}