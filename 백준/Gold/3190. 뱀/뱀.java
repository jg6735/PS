import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    private static int N, K, L, answer;
    private static int[][] board;
    private static boolean[][] visited;
    private static Deque<Coordinate> snake;
    private static char[] info;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int r = 0;
        int c = 0;
        int cnt = 1;
        int dir = 0;
        visited[r][c] = true;
        snake.add(new Coordinate(r, c));
        while (true) {
            Coordinate head = snake.peekLast();
            int nextR = head.getR() + DR[dir];
            int nextC = head.getC() + DC[dir];

            if (!isAvailable(nextR, nextC) || visited[nextR][nextC]) {
                answer = cnt;
                break;
            }

            if (hasApple(nextR, nextC)) {
                snake.addLast(new Coordinate(nextR, nextC));
                board[nextR][nextC] = 0;
            } else {
                snake.addLast(new Coordinate(nextR, nextC));
                Coordinate tail = snake.pollFirst();
                visited[tail.getR()][tail.getC()] = false;
            }

            visited[nextR][nextC] = true;
            
            if (info[cnt] == 'L') {
                dir = (dir + 3) % 4;
            } else if (info[cnt] == 'D') {
                dir = (dir + 1) % 4;
            }

            cnt++;
        }
    }

    private static boolean hasApple(int r, int c) {
        return board[r][c] == 1;
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        K = Integer.parseInt(in.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        info = new char[10001];
        snake = new ArrayDeque<>();

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1]++;
        }

        L = Integer.parseInt(in.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(in.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            info[X] = C;
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }

    private static class Coordinate {
        private int r;
        private int c;

        public Coordinate(int r, int c) {
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