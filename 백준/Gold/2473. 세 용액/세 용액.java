import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        search(arr);
    }

    private static void search(int[] arr) {
        int resultL = 0;
        int resultR = 0;
        int resultC = 0;
        long target = Long.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];
                if (Math.abs(sum) < Math.abs(target)) {
                    target = sum;
                    resultL = arr[i];
                    resultC = arr[left];
                    resultR = arr[right];
                }

                if (sum == 0) {
                    System.out.print(resultL + " " + resultC + " " + resultR);
                    return;
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.print(resultL + " " + resultC + " " + resultR);
    }
}