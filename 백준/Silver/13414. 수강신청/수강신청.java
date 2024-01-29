import java.io.*;
import java.util.*;

public class Main {

    private static int K, L;
    private static Set<String> set;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (L-- > 0) {
            String number = in.readLine();
            set.remove(number);
            set.add(number);
        }

        int count = 0;
        for (String s : set) {
            builder.append(s).append("\n");
            if (++count == K) {
                break;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        set = new LinkedHashSet<>();
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}