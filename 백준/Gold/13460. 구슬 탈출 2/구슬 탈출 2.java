import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, M, goalR, goalC, answer;
    private static Point start;
    private static char[][] board;
    private static boolean[][][][] visited;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.getRedR()][start.getRedC()][start.getBlueR()][start.getBlueC()] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.getCount() >= 10) {
                answer = -1;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nextRedR = cur.getRedR();
                int nextRedC = cur.getRedC();
                int nextBlueR = cur.getBlueR();
                int nextBlueC = cur.getBlueC();

                while (isAvailable(nextRedR + DR[d], nextRedC + DC[d])) {
                    nextRedR += DR[d];
                    nextRedC += DC[d];

                    if (nextRedR == goalR && nextRedC == goalC) {
                        break;
                    }
                }

                boolean isBlueIn = false;
                while (isAvailable(nextBlueR + DR[d], nextBlueC + DC[d])) {
                    nextBlueR += DR[d];
                    nextBlueC += DC[d];

                    if (nextBlueR == goalR && nextBlueC == goalC) {
                        isBlueIn = true;
                        break;
                    }
                }

                if (isBlueIn) {
                    continue;
                }

                if (nextRedR == goalR && nextRedC == goalC) {
                    answer = cur.getCount() + 1;
                    return;
                }

                // 0:상 1:우 2:하 3:좌
                if (nextRedR == nextBlueR && nextRedC == nextBlueC) {
                    if (d == 0) {
                        if (cur.getRedR() > cur.getBlueR()) {
                            nextRedR++;
                        } else {
                            nextBlueR++;
                        }
                    } else if (d == 1) {
                        if (cur.getRedC() > cur.getBlueC()) {
                            nextBlueC--;
                        } else {
                            nextRedC--;
                        }
                    } else if (d == 2) {
                        if (cur.getRedR() > cur.getBlueR()) {
                            nextBlueR--;
                        } else {
                            nextRedR--;
                        }
                    } else {
                        if (cur.getRedC() > cur.getBlueC()) {
                            nextRedC++;
                        } else {
                            nextBlueC++;
                        }
                    }
                }

                if (!visited[nextRedR][nextRedC][nextBlueR][nextBlueC]) {
                    queue.add(new Point(nextRedR, nextRedC, nextBlueR, nextBlueC, cur.getCount() + 1));
                    visited[nextRedR][nextRedC][nextBlueR][nextBlueC] = true;
                }
            }
        }

        answer = -1;
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M && board[r][c] != '#';
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];
        start = new Point();

        for (int r = 0; r < N; r++) {
            String input = in.readLine();
            for (int c = 0; c < M; c++) {
                char v = input.charAt(c);
                board[r][c] = v;
                if (v == 'R') {
                    start.setRedPoint(r, c);
                } else if (v == 'B') {
                    start.setBluePoint(r, c);
                } else if (v == 'O') {
                    goalR = r;
                    goalC = c;
                }
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }

    private static class Point {
        private int redR;
        private int redC;
        private int blueR;
        private int blueC;
        private int count;

        public Point() {
        }

        public Point(int redR, int redC, int blueR, int blueC, int count) {
            this.redR = redR;
            this.redC = redC;
            this.blueR = blueR;
            this.blueC = blueC;
            this.count = count;
        }

        public int getRedR() {
            return redR;
        }

        public int getRedC() {
            return redC;
        }

        public int getBlueR() {
            return blueR;
        }

        public int getBlueC() {
            return blueC;
        }

        public int getCount() {
            return count;
        }

        public void setRedPoint(int r, int c) {
            this.redR = r;
            this.redC = c;
        }

        public void setBluePoint(int r, int c) {
            this.blueR = r;
            this.blueC = c;
        }
    }
}