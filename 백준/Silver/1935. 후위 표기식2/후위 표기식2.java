import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        String input = in.readLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Deque<Double> deque = new ArrayDeque<>();
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char c = input.charAt(i);
            if ('A' <= c && c <= 'Z') {
                double d = arr[c - 'A'];
                deque.push(d);
            } else {
                double b = deque.pop();
                double a = deque.pop();
                double result = 0.0;

                if (c == '+') {
                    result = a + b;
                } else if (c == '-') {
                    result = a - b;
                } else if (c == '*') {
                    result = a * b;
                } else if (c == '/') {
                    result = a / b;
                }

                deque.push(result);
            }
        }

        System.out.printf("%.2f", deque.pop());
    }
}