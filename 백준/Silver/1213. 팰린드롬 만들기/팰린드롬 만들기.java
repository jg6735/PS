import java.io.*;

public class Main {

    private static final String FAIL = "I'm Sorry Hansoo";

    private static String answer;
    private static char[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        char[] count = new char['Z' + 1];
        for (char c : arr) {
            count[c]++;
        }

        int odd = 0;
        char center = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            if (count[i] % 2 == 1) {
                center = i;
                odd++;
            }
        }

        if (odd > 1) {
            answer = FAIL;
        } else {
            StringBuilder builder = new StringBuilder();
            for (char c = 'A'; c <= 'Z'; c++) {
                for (int j = 0; j < count[c] / 2; j++) {
                    builder.append(c);
                }
            }

            answer = builder.toString();
            if (center != 0) {
                builder.append(center);
            }

            answer += builder.reverse();
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = in.readLine().toCharArray();
    }

    private static void print() throws IOException {
        out.write(answer);
        out.flush();
        close();
    }

    private static void close() throws IOException {
        out.close();
        in.close();
    }
}