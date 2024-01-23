import java.io.*;

public class Main {

    private static int T;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (T-- > 0) {
            String input = in.readLine();
            int length = (int) Math.sqrt(input.length());
            char[][] arr = new char[length][length];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    arr[i][j] = input.charAt(i * length + j);
                }
            }

            for (int i = length - 1; i >= 0; i--) {
                for (int j = 0; j < length; j++) {
                    builder.append(arr[j][i]);
                }
            }

            builder.append("\n");
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        T = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}