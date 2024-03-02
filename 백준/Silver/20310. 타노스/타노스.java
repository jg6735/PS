import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static char[] arr;

    private static BufferedReader in;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int zero = 0;
        int one = 0;
        for (char c : arr) {
            if (c == '0') {
                zero++;
            } else {
                one++;
            }
        }

        int zeroCnt = zero / 2;
        int oneCnt = one / 2;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (zero == zeroCnt) {
                break;
            }

            if (arr[i] == '0') {
                arr[i] = '.';
                zero--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (one == oneCnt) {
                break;
            }

            if (arr[i] == '1') {
                arr[i] = '.';
                one--;
            }
        }

        for (char c : arr) {
            if (c != '.') {
                builder.append(c);
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        arr = in.readLine().toCharArray();
        builder = new StringBuilder();
    }

    private static void print() {
        System.out.println(builder);
    }
}