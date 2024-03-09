import java.io.*;

public class Main {

    private static int N, M, answer;
    private static String S;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int count = 0;
        for (int i = 0; i < M - 2; i++) {
            if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                count++;
                if (count == N) {
                    count--;
                    answer++;
                }

                i++;
            } else {
                count = 0;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        M = Integer.parseInt(in.readLine());
        S = in.readLine();
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}