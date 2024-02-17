import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    private static int N, M, K, answer;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Dice dice = new Dice(1, 6, 4, 3, 5, 2);
        search(dice, 0, 0, 0, 0, 0);
    }

    private static void search(Dice dice, int r, int c, int d, int cnt, int sum) {
        if (cnt == K) {
            answer = sum;
            return;
        }

        int nextR, nextC, nextD;
        if (!isAvailable(r + DR[d], c + DC[d])) {
            nextD = (d + 2) % 4;
        } else {
            nextD = d;
        }

        nextR = r + DR[nextD];
        nextC = c + DC[nextD];
        roll(dice, nextD);
        int score = bfs(nextR, nextC, new boolean[N][M]);
        int bottom = dice.getBottom();

        if (bottom > map[nextR][nextC]) {
            nextD = (nextD + 1) % 4;
        } else if (bottom < map[nextR][nextC]) {
            nextD = (nextD + 3) % 4;
        }

        search(dice, nextR, nextC, nextD, cnt + 1, sum + score);
    }

    private static int bfs(int r, int c, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c, 1));
        visited[r][c] = true;
        int score = map[r][c];

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int curCount = cur.getCount();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (isAvailable(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == map[r][c]) {
                    queue.add(new Coordinate(nextR, nextC, curCount + 1));
                    visited[nextR][nextC] = true;
                    score += map[nextR][nextC];
                }
            }
        }

        return score;
    }

    private static void roll(Dice dice, int dir) {
        int top = dice.getTop();
        int bottom = dice.getBottom();
        int left = dice.getLeft();
        int right = dice.getRight();
        int front = dice.getFront();
        int back = dice.getBack();

        if (dir == 0) {
            dice.setRight(top);
            dice.setBottom(right);
            dice.setLeft(bottom);
            dice.setTop(left);
        } else if (dir == 1) {
            dice.setFront(top);
            dice.setBottom(front);
            dice.setBack(bottom);
            dice.setTop(back);
        } else if (dir == 2) {
            dice.setLeft(top);
            dice.setBottom(left);
            dice.setRight(bottom);
            dice.setTop(right);
        } else {
            dice.setBack(top);
            dice.setBottom(back);
            dice.setFront(bottom);
            dice.setTop(front);
        }
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

    private static class Coordinate {
        private int r;
        private int c;
        private int count;

        public Coordinate(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getCount() {
            return count;
        }
    }

    private static class Dice {
        private int top;
        private int bottom;
        private int left;
        private int right;
        private int front;
        private int back;

        public Dice(int top, int bottom, int left, int right, int front, int back) {
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
            this.front = front;
            this.back = back;
        }

        public int getTop() {
            return top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getBottom() {
            return bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getFront() {
            return front;
        }

        public void setFront(int front) {
            this.front = front;
        }

        public int getBack() {
            return back;
        }

        public void setBack(int back) {
            this.back = back;
        }
    }
}