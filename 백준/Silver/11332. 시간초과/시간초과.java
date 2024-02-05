import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    private static final String PASS = "May Pass.";
    private static final String FAIL = "TLE!";

    private static int C, count;

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
        while (C-- > 0) {
            st = new StringTokenizer(in.readLine());
            String s = st.nextToken();
            String n = st.nextToken();
            BigInteger T = new BigInteger(st.nextToken());
            BigInteger L = new BigInteger(String.valueOf(Integer.parseInt(st.nextToken()) * count));
            BigInteger N = new BigInteger(n);

            switch (s) {
                case "O(N)":
                    if (N.multiply(T).compareTo(L) <= 0) {
                        builder.append(PASS);
                    } else {
                        builder.append(FAIL);
                    }

                    break;
                case "O(2^N)":
                    BigInteger temp = BigInteger.valueOf(2L);
                    if (temp.pow(N.intValue()).multiply(T).compareTo(L) <= 0) {
                        builder.append(PASS);
                    } else {
                        builder.append(FAIL);
                    }

                    break;
                case "O(N!)":
                    int num = N.intValue();
                    while (num-- > 1) {
                        N = N.multiply(new BigInteger(String.valueOf(num)));
                        if (N.compareTo(L) > 0) {
                            break;
                        }
                    }

                    if (N.multiply(T).compareTo(L) <= 0) {
                        builder.append(PASS);
                    } else {
                        builder.append(FAIL);
                    }

                    break;
                case "O(N^2)":
                    if (N.pow(2).multiply(T).compareTo(L) <= 0) {
                        builder.append(PASS);
                    } else {
                        builder.append(FAIL);
                    }

                    break;
                case "O(N^3)":
                    if (N.pow(3).multiply(T).compareTo(L) <= 0) {
                        builder.append(PASS);
                    } else {
                        builder.append(FAIL);
                    }

                    break;
            }

            builder.append("\n");
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        C = Integer.parseInt(in.readLine());
        count = (int) Math.pow(10, 8);
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}