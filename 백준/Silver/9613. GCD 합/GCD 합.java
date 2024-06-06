import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder();
        StringTokenizer st;
        while (t-- > 0) {
            st = new StringTokenizer(in.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            long sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    sum += getGcd(numbers[i], numbers[j]);
                }
            }

            builder.append(sum).append("\n");
        }

        System.out.print(builder);
    }

    static int getGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return getGcd(b, a % b);
    }
}