import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static String answer;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        for (int i = 0; i < M; i++) {
            int prev = 200_001;
            int k = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < k; j++) {
                int dummy = Integer.parseInt(st.nextToken());
                if (prev < dummy) {
                    answer = "No";
                    return;
                }

                prev = dummy;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = "Yes";
    }

    private static void print() throws IOException {
        out.write(answer);
        out.flush();
    }
}