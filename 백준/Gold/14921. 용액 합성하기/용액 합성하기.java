import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = Arrays.stream(in.readLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int left = 0;
        int right = N - 1;
        int result = Integer.MAX_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == 0) {
                result = sum;
                break;
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }

            if (Math.abs(sum) < Math.abs(result)) {
                result = sum;
            }
        }

        System.out.print(result);
    }
}