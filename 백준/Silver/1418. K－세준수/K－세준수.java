import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int K = Integer.parseInt(in.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int cur = i;
            int max = 0;
            int j = 2;
            while (j <= Math.sqrt(i)) {
                if (cur % j == 0) {
                    cur /= j;
                    max = j;
                } else {
                    j++;
                }
            }

            if (cur != 1) {
                max = cur;
            }

            if (max <= K) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}