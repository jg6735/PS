import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder result = new StringBuilder();
        while (T-- > 0) {
            int k = Integer.parseInt(in.readLine());
            String[] arr = new String[k];
            for (int i = 0; i < k; i++) {
                arr[i] = in.readLine();
            }

            boolean check = false;
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    StringBuilder builder = new StringBuilder();
                    if (i == j) {
                        continue;
                    }

                    builder.append(arr[i]).append(arr[j]);
                    if (isPalindrome(builder)) {
                        result.append(builder).append("\n");
                        check = true;
                        break;
                    }
                }

                if (check) {
                    break;
                }
            }

            if (!check) {
                result.append(0).append("\n");
            }
        }

        System.out.print(result);
    }

    static boolean isPalindrome(StringBuilder str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}