import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, answer;
    private static int[][] board;

    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        search(0);
    }

    private static void search(int cnt) {
        if (cnt == 5) {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    answer = Math.max(board[r][c], answer);
                }
            }

            return;
        }

        int[][] copied = copy(board);
        for (int d = 0; d < 4; d++) {
            if (d == 0) {
                moveUp(board);
            } else if (d == 1) {
                moveRight(board);
            } else if (d == 2) {
                moveDown(board);
            } else {
                moveLeft(board);
            }

            search(cnt + 1);
            board = copy(copied);
        }
    }

    private static void moveUp(int[][] arr) {
        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c < N; c++) {
                for (int nextR = r + 1; nextR < N; nextR++) {
                    if (move(arr, r, c, nextR, c)) {
                        break;
                    }
                }
            }
        }
    }

    private static void moveDown(int[][] arr) {
        for (int r = N - 1; r >= 1; r--) {
            for (int c = 0; c < N; c++) {
                for (int nextR = r - 1; nextR >= 0; nextR--) {
                    if (move(arr, r, c, nextR, c)) {
                        break;
                    }
                }
            }
        }
    }

    private static void moveLeft(int[][] arr) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N - 1; c++) {
                for (int nextC = c + 1; nextC < N; nextC++) {
                    if (move(arr, r, c, r, nextC)) {
                        break;
                    }
                }
            }
        }
    }

    private static void moveRight(int[][] arr) {
        for (int r = 0; r < N; r++) {
            for (int c = N - 1; c >= 1; c--) {
                for (int nextC = c - 1; nextC >= 0; nextC--) {
                    if (move(arr, r, c, r, nextC)) {
                        break;
                    }
                }
            }
        }
    }

    private static boolean move(int[][] arr, int r, int c, int nextR, int nextC) {
        if (arr[r][c] != 0 && arr[r][c] == arr[nextR][nextC]) {
            arr[r][c] *= 2;
            arr[nextR][nextC] = 0;
            return true;
        }

        if (arr[r][c] != 0 && arr[nextR][nextC] != 0 && arr[nextR][nextC] != arr[r][c]) {
            return true;
        }

        if (arr[r][c] == 0 && arr[nextR][nextC] != 0) {
            arr[r][c] = arr[nextR][nextC];
            arr[nextR][nextC] = 0;
        }

        return false;
    }

    private static int[][] copy(int[][] original) {
        int[][] copied = new int[N][N];

        for (int r = 0; r < N; r++) {
            System.arraycopy(original[r], 0, copied[r], 0, N);
        }

        return copied;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new int[N][N];
        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() {
        System.out.println(answer);
    }
}