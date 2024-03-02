import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, answer;
    private static int[][] board;
    private static int[] deltas;

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
            int[][] copied = copy(board);

            for (int i = 0; i < 5; i++) {
                int dir = deltas[i];

                if (dir == 0) {
                    moveUp(copied);
                } else if (dir == 1) {
                    moveRight(copied);
                } else if (dir == 2) {
                    moveDown(copied);
                } else {
                    moveLeft(copied);
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    answer = Math.max(copied[r][c], answer);
                }
            }

            return;
        }


        for (int d = 0; d < 4; d++) {
            deltas[cnt] = d;
            search(cnt + 1);
        }
    }

    private static void moveUp(int[][] arr) {
        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c < N; c++) {
                for (int nextR = r + 1; nextR < N; nextR++) {
                    if (moveRow(arr, r, c, nextR)) {
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
                    if (moveRow(arr, r, c, nextR)) {
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
                    if (moveCol(arr, r, c, nextC)) {
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
                    if (moveCol(arr, r, c, nextC)) {
                        break;
                    }
                }
            }
        }
    }

    private static boolean moveRow(int[][] arr, int r, int c, int nextR) {
        if (arr[r][c] != 0 && arr[r][c] == arr[nextR][c]) {
            arr[r][c] *= 2;
            arr[nextR][c] = 0;
            return true;
        }

        if (arr[r][c] != 0 && arr[nextR][c] != 0 && arr[nextR][c] != arr[r][c]) {
            return true;
        }

        if (arr[r][c] == 0 && arr[nextR][c] != 0) {
            arr[r][c] = arr[nextR][c];
            arr[nextR][c] = 0;
        }

        return false;
    }

    private static boolean moveCol(int[][] arr, int r, int c, int nextC) {
        if (arr[r][c] != 0 && arr[r][c] == arr[r][nextC]) {
            arr[r][c] *= 2;
            arr[r][nextC] = 0;
            return true;
        }

        if (arr[r][c] != 0 && arr[r][nextC] != 0 && arr[r][nextC] != arr[r][c]) {
            return true;
        }

        if (arr[r][c] == 0 && arr[r][nextC] != 0) {
            arr[r][c] = arr[r][nextC];
            arr[r][nextC] = 0;
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

    private static void printArr() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(board[r][c] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        board = new int[N][N];
        deltas = new int[5];
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