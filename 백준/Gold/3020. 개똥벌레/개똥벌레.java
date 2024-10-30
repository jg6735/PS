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
        int H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[N / 2];
        int[] top = new int[N / 2];
        for (int i = 0; i < N / 2; i++) {
            bottom[i] = Integer.parseInt(in.readLine());
            top[i] = Integer.parseInt(in.readLine());
        }

        Arrays.sort(top);
        Arrays.sort(bottom);

        int min = Integer.MAX_VALUE;
        int minCount = 0;
        for (int h = 1; h <= H; h++) {
            int bottomCount = N / 2 - search(h, bottom, N);
            int topCount = N / 2 - search(H - h + 1, top, N);
            int count = bottomCount + topCount;
            if (count < min) {
                min = count;
                minCount = 1;
            } else if (count == min) {
                minCount++;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(min).append(" ").append(minCount);
        System.out.print(builder);
    }

    private static int search(int target, int[] arr, int N) {
        int left = 0;
        int right = N / 2;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}