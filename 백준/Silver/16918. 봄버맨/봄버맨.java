import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int R, C, N;
    private static Coordinate[][] board;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int count = 0;
        while (N > count++) {
            if (count % 2 == 0) {
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        Coordinate cur = board[r][c];
                        if (cur.getBomb() == '.') {
                            cur.setBomb();
                            cur.count(count + 3);
                        }
                    }
                }
            } else {
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        Coordinate cur = board[r][c];
                        if (cur.getCount() == count) {
                            cur.explode();

                            for (int d = 0; d < 4; d++) {
                                int nextR = cur.getR() + DR[d];
                                int nextC = cur.getC() + DC[d];

                                if (!isAvailable(nextR, nextC)) {
                                    continue;
                                }

                                if (board[nextR][nextC].getBomb() == 'O' && board[nextR][nextC].getCount() != count) {
                                    board[nextR][nextC].explode();
                                    board[nextR][nextC].count(0);
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                builder.append(board[r][c].getBomb());
            }
            builder.append("\n");
        }
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new Coordinate[R][C];

        for (int r = 0; r < R; r++) {
            String input = in.readLine();
            for (int c = 0; c < C; c++) {
                char bomb = input.charAt(c);
                board[r][c] = new Coordinate(r, c, 0, bomb);
                if (bomb == 'O') {
                    board[r][c].count(3);
                }
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }

    private static class Coordinate {
        private final int r;
        private final int c;
        private int count;
        private char bomb;

        public Coordinate(int r, int c, int count, char bomb) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.bomb = bomb;
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

        public char getBomb() {
            return bomb;
        }

        private void count(int count) {
            this.count = count;
        }

        private void setBomb() {
            this.bomb = 'O';
        }

        private void explode() {
            this.bomb = '.';
        }
    }
}