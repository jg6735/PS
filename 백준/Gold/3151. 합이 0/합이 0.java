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

        long answer = 0;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    if (arr[left] == arr[right]) {
                        int count = right - left + 1;
                        answer += ((long) count * (count - 1)) / 2;
                        break;
                    }

                    int leftCount = 1;
                    int rightCount = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        leftCount++;
                        left++;
                    }

                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rightCount++;
                        right--;
                    }

                    answer += (long) leftCount * rightCount;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.print(answer);
    }
}