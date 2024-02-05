import java.io.*;

public class Main {

    private static int N;
    private static char[][] arr;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        if (N == 1) {
            builder.append("*");
            return;
        }

        int col = N * 4 - 3;
        int row = col + 2;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                arr[r][c] = ' ';
            }
        }

        int r = 0;
        int c = N * 4 - 4;
        recursion(N, r, c);

        for (int i = 0; i < row; i++) {
            if (i == 1) {
                builder.append('*').append("\n");
                continue;
            }

            for (int j = 0; j < col; j++) {
                builder.append(arr[i][j]);
            }

            builder.append("\n");
        }
    }

    private static void recursion(int n, int r, int c) {
        int col = n * 4 - 3;
        int row = col + 2;

        for (int i = 1; i < col; i++) {
            arr[r][c--] = '*';
        }

        for (int i = 1; i < row; i++) {
            arr[r++][c] = '*';
        }

        for (int i = 1; i < col; i++) {
            arr[r][c++] = '*';
        }

        for (int i = 1; i < row - 2; i++) {
            arr[r--][c] = '*';
        }

        arr[r][c] = '*';
        arr[r][--c] = '*';

        if (n == 2) {
            arr[r][c - 1] = '*';
            arr[r + 1][c - 1] = '*';
            arr[r + 2][c - 1] = '*';
            return;
        }

        recursion(n - 1, r, c - 1);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        arr = new char[(N - 1) * 4 + 3][(N - 1) * 4 + 1];
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}