import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] scores = new int[10];
        int result = 0;

        for (int i = 0; i < 10; i++) {
            scores[i] = Integer.parseInt(in.readLine());
        }

        int prev = 0;
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += scores[i];
            if (sum >= 100) {
                if (check(sum) > check(prev)) {
                    result = prev;
                } else {
                    result = sum;
                }

                break;
            }

            result = sum;
            prev = sum;
        }

        System.out.print(result);
    }

    private static int check(int sum) {
        return Math.abs(100 - sum);
    }
}