import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = left + 1;
        while (right < N) {
            int diff = arr[right] - arr[left];
            if (diff >= M) {
                min = Math.min(min, diff);
                left++;
            } else {
                right++;
            }
            
            if (left == right) {
                right++;
            }
        }

        System.out.print(min);
    }
}