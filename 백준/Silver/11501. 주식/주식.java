import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringTokenizer st;
        StringBuilder builder = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            int[] prices = new int[N];
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = prices[N - 1];
            for (int i = N - 2; i >= 0; i--) {
                if (prices[i] <= max) {
                    answer += max - prices[i];
                } else {
                    max = prices[i];
                }
            }

            builder.append(answer).append("\n");
        }

        System.out.print(builder);
    }
}