import java.io.*;

public class Main {

    private static int answer;
    private static String S, T;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        StringBuilder tBuilder = new StringBuilder(T);
        while (S.length() < tBuilder.length()) {
            if (tBuilder.charAt(tBuilder.length() - 1) == 'A') {
                tBuilder.deleteCharAt(tBuilder.length() - 1);
            } else if (tBuilder.charAt(tBuilder.length() - 1) == 'B') {
                tBuilder.deleteCharAt(tBuilder.length() - 1).reverse();
            }
        }

        answer = tBuilder.toString().equals(S) ? 1 : 0;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        S = in.readLine();
        T = in.readLine();
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}