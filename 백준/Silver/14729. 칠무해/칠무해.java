import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[100_001];
        for (int i = 0; i < N; i++) {
            arr[(int) (Double.parseDouble(in.readLine()) * 1_000)]++;
        }

        StringBuilder builder = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0 && cnt < 7) {
                String format = String.format("%.3f", i / 1000.0);
                builder.append(format).append("\n");
                arr[i]--;
                cnt++;
            }
        }

        System.out.print(builder);
    }
}
