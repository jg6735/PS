import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] numbers;
    static boolean[] isSelected;
    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        numbers = new int[N];
        isSelected = new boolean[N + 1];
        builder = new StringBuilder();
        permutation(0);
        System.out.print(builder);
    }

    static void permutation(int depth) {
        if (depth == N) {
            for (int number : numbers) {
                builder.append(number).append(" ");
            }

            builder.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (isSelected[i]) {
                continue;
            }

            numbers[depth] = i;
            isSelected[i] = true;
            permutation(depth + 1);
            isSelected[i] = false;
        }
    }
}