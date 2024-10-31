import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int target = arr[i];
            int left = 0;
            int right = N - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                }

                if (right == i) {
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];
                if (sum == target) {
                    answer++;
                    break;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}