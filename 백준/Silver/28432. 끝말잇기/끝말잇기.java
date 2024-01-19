import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static int N, M, idx;
    private static String answer = "";
    private static List<String> words, list;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        if (N == 1) {
            return;
        }

        char start, last;
        if (idx == 0) {
            start = words.get(idx + 1).charAt(0);

            for (String str : list) {
                if (str.charAt(str.length() - 1) == start && !words.contains(str)) {
                    answer = str;
                    break;
                }
            }
        } else if (idx == N - 1) {
            last = words.get(idx - 1).charAt(words.get(idx - 1).length() - 1);

            for (String str : list) {
                if (str.charAt(0) == last && !words.contains(str)) {
                    answer = str;
                    break;
                }
            }
        } else {
            start = words.get(idx + 1).charAt(0);
            last = words.get(idx - 1).charAt(words.get(idx - 1).length() - 1);

            for (String str : list) {
                if (str.charAt(str.length() - 1) == start && str.charAt(0) == last && !words.contains(str)) {
                    answer = str;
                    break;
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        words = new ArrayList<>();
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            if (input.equals("?")) {
                idx = i;
            }

            words.add(input);
        }

        M = Integer.parseInt(in.readLine());
        for (int i = 0; i < M; i++) {
            String input = in.readLine();
            if (N == 1) {
                answer = input;
                return;
            }

            list.add(input);
        }
    }

    private static void print() throws IOException {
        out.write(answer);
        out.flush();
    }
}