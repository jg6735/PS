import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, K, answer;
    private static int[][] map;
    private static List<int[][]> list;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int[][] arr : list) {
            int row = arr.length;
            int col = arr[0].length;
            if (checkMap(arr, row, col)) {
                continue;
            }

            int[][] copied = rotate(arr, row, col);
            for (int i = 0; i < 3; i++) {
                if (!checkMap(copied, copied.length, copied[0].length)) {
                    copied = rotate(copied, copied.length, copied[0].length);
                } else {
                    break;
                }
            }
        }
    }

    private static int[][] rotate(int[][] arr, int row, int col) {
        int[][] copied = new int[col][row];
        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                copied[c][r] = arr[row - r - 1][c];
            }
        }

        return copied;
    }

    private static boolean checkMap(int[][] arr, int row, int col) {
        for (int i = 0; i <= N - row; i++) {
            for (int j = 0; j <= M - col; j++) {
                if (isEmptyMap(arr, i, j, row, col)) {
                    putSticker(arr, i, j, row, col);
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isEmptyMap(int[][] arr, int startR, int startC, int row, int col) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (arr[r][c] == 1 && map[startR + r][startC + c] == 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void putSticker(int[][] arr, int startR, int startC, int row, int col) {
        for (int r = startR; r < startR + row; r++) {
            for (int c = startC; c < startC + col; c++) {
                if (arr[r - startR][c - startC] == 1) {
                    map[r][c] = 1;
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        list = new ArrayList<>();

        int R, C;
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(in.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int[][] arr = new int[R][C];
            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(in.readLine());
                for (int c = 0; c < C; c++) {
                    arr[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            list.add(arr);
        }
    }

    private static void print() throws IOException {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1) {
                    answer++;
                }
            }
        }

        out.write(Integer.toString(answer));
        out.flush();
    }
}