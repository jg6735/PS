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
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        int min = 1;
        int max = arr[N - 1] - arr[0] + 1;
        while (min < max) {
            int mid = (min + max) / 2;

            if (set(arr, mid) < C) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }

    private static int set(int[] arr, int distance) {
        int count = 0;
        int start = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];

            if (next - start >= distance) {
                count++;
                start = next;
            }
        }

        return count + 1;
    }
}