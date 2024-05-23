import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String input = "";
        while ((input = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int answer = 0;
            for (int i = N; i <= M; i++) {
                if (isDuplicated(i)) {
                    answer++;
                }
            }

            builder.append(answer).append("\n");
        }

        System.out.print(builder);
    }

    static boolean isDuplicated(int number) {
        int[] arr = new int[10];
        while (number > 0) {
            if (++arr[number % 10] > 1) {
                return false;
            }

            number /= 10;
        }

        return true;
    }
}