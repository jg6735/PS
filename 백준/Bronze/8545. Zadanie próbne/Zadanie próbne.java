import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder builder;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
       
        builder = new StringBuilder(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.reverse().toString());
        out.flush();
    }
}