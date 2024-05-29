import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in.readLine().toCharArray();
        final String UCPC = "UCPC";

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == UCPC.charAt(idx)) {
                idx++;

                if (idx >= 4) {
                    break;
                }
            }
        }

        System.out.print(idx == 4 ? "I love UCPC" : "I hate UCPC");
    }
}