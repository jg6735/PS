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
        int left = 0;
        int right = arr.length - 1;
        int target = Integer.MAX_VALUE;
        int resultL = arr[left];
        int resultR = arr[right];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < Math.abs(target)) {
                target = sum;
                resultL = arr[left];
                resultR = arr[right];
            }

            if (sum == 0) {
                break;
            }

            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.print(resultL + " " + resultR);
    }
}