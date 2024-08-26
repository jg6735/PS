import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int[] arr = new int[26];
            String input = in.readLine();
            char[] first = input.split(" ")[0].toCharArray();
            char[] second = input.split(" ")[1].toCharArray();
            for (char c : first) {
                arr[c - 'a']++;
            }
            for (char c : second) {
                arr[c - 'a']--;
            }

            boolean check = false;
            for (int j : arr) {
                if (j != 0) {
                    check = true;
                }
            }

            builder.append(check ? "Impossible" : "Possible").append("\n");
        }

        System.out.print(builder);
    }
}