import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder();

        while (T-- > 0) {
            int number = Integer.parseInt(in.readLine());
            boolean check = false;
            for (int i = 2; i <= 64; i++) {
                String converted = convert(number, i);
                StringBuilder reverse = new StringBuilder(converted).reverse();
                if (converted.contentEquals(reverse)) {
                    builder.append(1).append("\n");
                    check = true;
                    break;
                }
            }

            if (!check) {
                builder.append(0).append("\n");
            }
        }

        System.out.print(builder);
    }

    static String convert(int number, int radix) {
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            int remainder = number % radix;
            if (remainder < 10) {
                result.append(remainder);
            } else {
                result.append((char) (remainder - 10 + 'A'));
            }

            number /= radix;
        }

        return result.toString();
    }
}