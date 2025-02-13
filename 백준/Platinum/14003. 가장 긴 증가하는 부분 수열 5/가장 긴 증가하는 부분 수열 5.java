import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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

        int[] lastIdx = new int[N];
        int[] prev = new int[N];
        Arrays.fill(prev, -1);
        int len = 0;
        for (int i = 0; i < N; i++) {
            int left = binarySearch(len, arr, lastIdx, i);
            if (left > 0) {
                prev[i] = lastIdx[left - 1];
            }

            lastIdx[left] = i;
            if (left == len) {
                len++;
            }
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int idx = lastIdx[len - 1];
        while (idx != -1) {
            deque.push(arr[idx]);
            idx = prev[idx];
        }

        StringBuilder builder = new StringBuilder();
        builder.append(len).append("\n");
        while (!deque.isEmpty()) {
            builder.append(deque.pop()).append(" ");
        }

        System.out.print(builder);
    }

    private static int binarySearch(int len, int[] arr, int[] lastIdx, int i) {
        int left = 0;
        int right = len;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[lastIdx[mid]] < arr[i]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }

}