import java.io.*;
import java.util.Stack;

public class Main {

    private static int answer;
    private static char[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Stack<Character> stack = new Stack<>();
        int sum = 1;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '(') {
                stack.push(c);
                sum *= 2;
            } else if (c == '[') {
                stack.push(c);
                sum *= 3;
            } else {
                if (c == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        return;
                    } else if (arr[i - 1] == '(') {
                        answer += sum;
                    }

                    sum /= 2;
                } else if (c == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        return;
                    } else if (arr[i - 1] == '[') {
                        answer += sum;
                    }

                    sum /= 3;
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            answer = 0;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = in.readLine().toCharArray();
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}