import java.io.*;

public class Main {

    private static char[][] arr;
    private static int N;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        recursion(0, 0, N);
        int length = (N - 1) * 4 + 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (arr[i][j] != '*') {
                    arr[i][j] = ' ';
                }

                builder.append(arr[i][j]);
            }

            builder.append("\n");
        }
    }

    private static void recursion(int r, int c, int cnt) {
        if (cnt == 1) {
            arr[r][c] = '*';
            return;
        }

        int size = (cnt - 1) * 4 + 1;
        for (int i = 0; i < size; i++) {
            arr[r][c + i] = '*';
            arr[r + size - 1][c + i] = '*';
        }

        for (int i = 0; i < size - 1; i++) {
            arr[r + i][c] = '*';
            arr[r + i][c + size - 1] = '*';
        }

        recursion(r + 2, c + 2, cnt - 1);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        arr = new char[397][397];
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}