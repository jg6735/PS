import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] dist = {2, -1, 1};

    private static int N, K, answer;
    private static boolean[] visited;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(N, 0));
        visited[N] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int curX = cur.getX();
            int curCount = cur.getCount();

            if (curX == K) {
                answer = curCount;
                return;
            }

            for (int d = 0; d < 3; d++) {
                int next;
                if (d == 0) {
                    next = curX * dist[d];
                    if (next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        queue.add(new Point(next, curCount));
                    }
                } else {
                    next = curX + dist[d];
                    if (next >= 0 && next <= 100000 && !visited[next]) {
                        visited[next] = true;
                        queue.add(new Point(next, curCount + 1));
                    }
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        answer = Integer.MAX_VALUE;
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

    private static class Point {
        private int x;
        private int count;

        public Point(int x, int count) {
            this.x = x;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getCount() {
            return count;
        }
    }
}