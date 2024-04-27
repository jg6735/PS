import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static String S;
    private static int q, l, r, answer;
    private static char a;
    private static int[][] sums;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(in.readLine());
            a = st.nextToken().charAt(0);
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            if (l == 0) {
                builder.append(sums[r][a]);
            } else {
                builder.append(sums[r][a] - sums[l - 1][a]);
            }

            builder.append("\n");
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        S = in.readLine();
        q = Integer.parseInt(in.readLine());
        sums = new int[S.length() + 1]['z' + 1];
        int[] sum = new int['z' + 1];
        for (int i = 0; i < S.length(); i++) {
            sum[S.charAt(i)]++;
            System.arraycopy(sum, 'a', sums[i], 'a', 'z' - 'a' + 1);
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}