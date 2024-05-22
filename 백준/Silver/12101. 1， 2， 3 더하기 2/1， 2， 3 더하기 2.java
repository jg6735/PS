import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main
{
    static int n, k, count;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int[] numbers = new int[]{1, 2, 3};
        int[] isSelected = new int[11];
        recursion(numbers, isSelected, 0, 0);

        if (k != 0) {
            System.out.print("-1");
        } else {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < count; i++) {
                builder.append(isSelected[i]).append("+");
            }

            builder.setLength(builder.length() - 1);
            System.out.print(builder);
        }
    }

    static void recursion(int[] numbers, int[] isSelected, int depth, int sum) {
        if (sum == n) {
            count = depth;
            k--;
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (numbers[i] + sum > n || k == 0) {
                break;
            }

            isSelected[depth] = numbers[i];
            recursion(numbers, isSelected, depth + 1, sum + numbers[i]);
        }
    }
}
