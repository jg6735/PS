import java.io.*;
import java.util.Stack;

public class Main {

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        int tc = 1;
        String input = "";
        while (!(input = in.readLine()).startsWith("-")) {
            Stack<Character> stack = new Stack<>();
            int result = 0;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '{') {
                    stack.add(c);
                } else {
                    if (stack.isEmpty()) {
                        stack.add('{');
                        result++;
                    } else {
                        stack.pop();
                    }
                }
            }

            result += stack.size() / 2;
            builder.append(tc++).append(". ").append(result).append("\n");
        }
    }

    private static void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}