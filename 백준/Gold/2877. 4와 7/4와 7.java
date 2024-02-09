import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int K;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        while (K > 0) {
            sb.append(K % 2);
            K /= 2;
        }

        for (int i = sb.length() - 2; i >= 0; i--) {
            if (sb.charAt(i) == '0') {
                builder.append(4);
            } else {
                builder.append(7);
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        K = Integer.parseInt(in.readLine()) + 1;
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}