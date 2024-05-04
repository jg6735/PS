import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int k = Integer.parseInt(in.readLine());

        int start = 1;
        int end = k;
        int target = 0;

        while (start <= end) {
            int idx = 0;
            int mid = (start + end) / 2;

            for (int i = 1; i < N + 1; i++) {
                idx += Math.min(mid / i, N);
            }

            if (idx >= k) {
                target = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(target);
    }
}