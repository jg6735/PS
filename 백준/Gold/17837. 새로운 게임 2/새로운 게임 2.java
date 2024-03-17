import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, 0, -1, 1};
    private static final int[] DC = {1, -1, 0, 0};

    private static int N, K, answer = -1;
    private static int[][][] board;
    private static Piece[][][] pieces;
    private static Piece[] list;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int count = 0;
        while (++count <= 1000) {
            for (Piece piece : list) {
                boolean isGameOver = piece.move(pieces, board);
                if (isGameOver) {
                    answer = count;
                    return;
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
        pieces = new Piece[N][N][K];
        board = new int[N][N][2];
        list = new Piece[K];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c][0] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            list[i] = new Piece(r, c, dir, 0, i + 1);
            board[r][c][1]++;
            pieces[r][c][0] = list[i];
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

    static class Piece {
        private final int number;
        private int r;
        private int c;
        private int dir;
        private int index;

        public Piece(int r, int c, int dir, int index, int number) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.index = index;
            this.number = number;
        }

        private static boolean isInside(int r, int c) {
            return r >= 0 && c >= 0 && r < N && c < N;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getNumber() {
            return number;
        }

        public void moveWhite(Piece[][][] pieces, int[][][] board, int nextR, int nextC) {
            int startR = r;
            int startC = c;
            int start = index;
            int cnt = board[startR][startC][1];
            int nextCnt = board[nextR][nextC][1];
            for (int i = start; i < cnt; i++) {
                Piece piece = pieces[startR][startC][i];
                board[piece.getR()][piece.getC()][1]--;
                pieces[piece.getR()][piece.getC()][i] = null;
                piece.setR(nextR);
                piece.setC(nextC);
                piece.setIndex(nextCnt);
                pieces[nextR][nextC][nextCnt++] = piece;
                board[nextR][nextC][1]++;
            }
        }

        public void moveRed(Piece[][][] pieces, int[][][] board, int nextR, int nextC) {
            int startR = r;
            int startC = c;
            int lastIdx = index;
            int cnt = board[startR][startC][1];
            int nextCnt = board[nextR][nextC][1];
            for (int i = cnt - 1; i >= lastIdx; i--) {
                Piece piece = pieces[startR][startC][i];
                board[piece.getR()][piece.getC()][1]--;
                pieces[piece.getR()][piece.getC()][i] = null;
                piece.setR(nextR);
                piece.setC(nextC);
                piece.setIndex(nextCnt);
                pieces[nextR][nextC][nextCnt++] = piece;
                board[nextR][nextC][1]++;
            }
        }

        public boolean move(Piece[][][] pieces, int[][][] board) {
            int nextR = r + DR[dir];
            int nextC = c + DC[dir];

            if (!isInside(nextR, nextC) || board[nextR][nextC][0] == 2) {
                setDir(dir % 2 == 0 ? dir + 1 : dir - 1);
                nextR = r + DR[dir];
                nextC = c + DC[dir];

                if (isInside(nextR, nextC)) {
                    if (board[nextR][nextC][0] == 0) {
                        moveWhite(pieces, board, nextR, nextC);
                    } else if (board[nextR][nextC][0] == 1) {
                        moveRed(pieces, board, nextR, nextC);
                    }
                }
            } else if (board[nextR][nextC][0] == 0) {
                moveWhite(pieces, board, nextR, nextC);
            } else if (board[nextR][nextC][0] == 1) {
                moveRed(pieces, board, nextR, nextC);
            }

            return board[r][c][1] >= 4;
        }
    }
}