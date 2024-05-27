import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[53];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        String str = in.readLine();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isCorrect = true;
            if (Character.isWhitespace(c)) {
                if (--arr[0] < 0) {
                    isCorrect = false;
                }
            } else if (Character.isUpperCase(c)) {
                if (--arr[c - 'A' + 1] < 0) {
                    isCorrect = false;
                }
            } else {
                if (--arr[c - 'a' + 27] < 0) {
                    isCorrect = false;
                }
            }

            if (!isCorrect) {
                System.out.print("n");
                return;
            }
        }

        System.out.print("y");
    }
}