import java.io.*;

public class Main {

    private static int N, answer;
    private static char[][] board;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (r + 1 < N && board[r][c] != board[r + 1][c]) {
                    swap(r, c, r + 1, c);
                    search();
                    swap(r, c, r + 1, c);
                }

                if (c + 1 < N && board[r][c] != board[r][c + 1]) {
                    swap(r, c, r, c + 1);
                    search();
                    swap(r, c, r, c + 1);
                }
            }
        }
    }

    private static void swap(int curR, int curC, int nextR, int nextC) {
        char temp = board[curR][curC];
        board[curR][curC] = board[nextR][nextC];
        board[nextR][nextC] = temp;
    }

    private static void search() {
        for (int r = 0; r < N; r++) {
            int cnt = 1;
            for (int c = 0; c < N - 1; c++) {
                if (board[r][c] == board[r][c + 1]) {
                    cnt++;
                    answer = Math.max(answer, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        for (int c = 0; c < N; c++) {
            int cnt = 1;
            for (int r = 0; r < N - 1; r++) {
                if (board[r][c] == board[r + 1][c]) {
                    cnt++;
                    answer = Math.max(answer, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = in.readLine().toCharArray();
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}