import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int left = 0;
        int len = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            while (sum >= S) {
                len = Math.min(len, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        System.out.print(len == Integer.MAX_VALUE ? 0 : len);
    }
}