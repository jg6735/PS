import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N;
    private static char[] inputs;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int d = 0;

        int maxR = 0;
        int maxC = 0;
        int minR = 0;
        int minC = 0;
        Deque<Point> deque = new ArrayDeque<>();
        Point start = new Point(0, 0);
        deque.push(start);
        for (int i = 0; i < N; i++) {
            char move = inputs[i];
            if (move == 'L') {
                d = (d + 4 + 1) % 4;
            } else if (move == 'R') {
                d = (d + 4 - 1) % 4;
            } else {
                Point cur = deque.peek();
                int nextR = cur.getR() + DR[d];
                int nextC = cur.getC() + DC[d];

                maxR = Math.max(maxR, nextR);
                maxC = Math.max(maxC, nextC);
                minR = Math.min(minR, nextR);
                minC = Math.min(minC, nextC);
                deque.push(new Point(nextR, nextC));
            }
        }

        char[][] map = new char[maxR - minR + 1][maxC - minC + 1];
        while (!deque.isEmpty()) {
            Point cur = deque.pop();
            int curR = cur.getR();
            int curC = cur.getC();
            map[curR - minR][curC - minC] = '.';
        }

        for (char[] chars : map) {
            for (char c : chars) {
                if (c == '.') {
                    builder.append('.');
                } else {
                    builder.append('#');
                }
            }

            builder.append("\n");
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        inputs = new char[N];
        String input = in.readLine();
        for (int i = 0; i < N; i++) {
            inputs[i] = input.charAt(i);
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }

    private static class Point {
        private final int r;
        private final int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }
    }
}