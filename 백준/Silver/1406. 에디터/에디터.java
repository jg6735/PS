import java.io.*;
import java.util.Stack;

public class Main {

    private static Stack<Character> stack;
    private static Stack<Character> temp;
    private static int M;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (M-- > 0) {
            String input = in.readLine();
            char c = input.charAt(0);
            if (c == 'L' && !stack.isEmpty()) {
                temp.push(stack.pop());
            } else if (c == 'D' && !temp.isEmpty()) {
                stack.push(temp.pop());
            } else if (c == 'B' && !stack.isEmpty()) {
                stack.pop();
            } else if (c == 'P') {
                stack.push(input.charAt(2));
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        stack = new Stack<>();
        temp = new Stack<>();
        String str = in.readLine();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }

        M = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        for (Character c : stack) {
            out.write(c);
        }

        out.flush();
    }
}