import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N, answer;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(in.readLine());
        }

        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            if (list.indexOf(input) != 0) {
                list.remove(input);
                answer++;
            } else {
                list.remove(input);
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}