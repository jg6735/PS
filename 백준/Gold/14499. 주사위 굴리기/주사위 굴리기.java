import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, 0, -1, 1};
    private static final int[] DC = {1, -1, 0, 0};

    private static int N, M, R, C, K;
    private static Dice dice;
    private static int[][] map;
    private static int[] dirs;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < K; i++) {
            int dir = dirs[i];
            int nextR = dice.getR() + DR[dir];
            int nextC = dice.getC() + DC[dir];

            if (!isAvailable(nextR, nextC)) {
                continue;
            }

            roll(dir, nextR, nextC);
            if (map[nextR][nextC] == 0) {
                map[nextR][nextC] = dice.getBottom();
            } else {
                dice.setBottom(map[nextR][nextC]);
                map[nextR][nextC] = 0;
            }
            
            builder.append(dice.getTop()).append("\n");
        }
    }

    private static void roll(int dir, int r, int c) {
        int top = dice.getTop();
        int bottom = dice.getBottom();
        int left = dice.getLeft();
        int right = dice.getRight();
        int front = dice.getFront();
        int back = dice.getBack();

        dice.setDice(r, c);
        if (dir == 0) {
            dice.setTop(left);
            dice.setLeft(bottom);
            dice.setBottom(right);
            dice.setRight(top);
        } else if (dir == 1) {
            dice.setTop(right);
            dice.setLeft(top);
            dice.setBottom(left);
            dice.setRight(bottom);
        } else if (dir == 2) {
            dice.setTop(front);
            dice.setFront(bottom);
            dice.setBottom(back);
            dice.setBack(top);
        } else {
            dice.setTop(back);
            dice.setFront(top);
            dice.setBottom(front);
            dice.setBack(bottom);
        }
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dirs = new int[K];
        dice = new Dice(0, 0, 0, 0, 0, 0);
        dice.setDice(R, C);

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < K; i++) {
            dirs[i] = Integer.parseInt(st.nextToken()) - 1;
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }

    private static class Dice {
        private int r;
        private int c;
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

        public void setDice(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getTop() {
            return top;
        }

        public int getBottom() {
            return bottom;
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getFront() {
            return front;
        }

        public int getBack() {
            return back;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public void setFront(int front) {
            this.front = front;
        }

        public void setBack(int back) {
            this.back = back;
        }
    }
}