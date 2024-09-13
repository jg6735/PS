import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String input = br.readLine();
        
        Deque<Character> stack = new ArrayDeque<>();
        int count = K;

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            while (!stack.isEmpty() && count > 0 && stack.peek() < c) {
                stack.pop();
                count--;
            }

            stack.push(c);
        }

        while (count > 0) {
            stack.pop();
            count--;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }

        System.out.print(builder);
    }
}