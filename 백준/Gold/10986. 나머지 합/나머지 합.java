import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static long answer;
    private static int[] divided;
    private static long[] sums;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        st = new StringTokenizer(in.readLine());
        for (int i = 1; i < N + 1; i++) {
            sums[i] = (sums[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if (sums[i] == 0) {
                answer++;
            }

            divided[(int) sums[i]]++;
        }

        for (long l : divided) {
            if (l > 1) {
                answer += l * (l - 1) / 2;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sums = new long[N + 1];
        divided = new int[M];
    }

    private static void print() throws IOException {
        out.write(Long.toString(answer));
        out.flush();
    }
}