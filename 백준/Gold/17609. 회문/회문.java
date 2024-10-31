import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            char[] words = in.readLine().toCharArray();
            isPalindrome(words);
        }

        System.out.print(builder);
    }

    private static void isPalindrome(char[] words) {
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            if (words[left] != words[right]) {
                if (isPalindrome(words, left + 1, right) || isPalindrome(words, left, right - 1)) {
                    builder.append(1).append("\n");
                } else {
                    builder.append(2).append("\n");
                }

                return;
            }

            left++;
            right--;
        }

        builder.append(0).append("\n");
    }

    private static boolean isPalindrome(char[] words, int left, int right) {
        while (left < right) {
            if (words[left] != words[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}