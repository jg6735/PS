import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        int answer = Integer.MAX_VALUE;
        int max = n / 5;
        while (max >= 0) {
            int total = n;
            int result = 0;
            if (max != 0) {
                result += max;
                total -= (max * 5);
            }

            max--;
            if (total % 2 == 0) {
                result += total / 2;
            } else {
                continue;
            }

            answer = Math.min(answer, result);
        }

        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(answer);
        }
    }
}