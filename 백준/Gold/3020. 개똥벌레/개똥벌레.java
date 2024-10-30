import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
        Map<Integer, Integer> map = new TreeMap<>();
        for (int target = 1; target <= H; target++) {
            int bottomCount = N / 2 - search(target, bottom, N);
            int topCount = N / 2 - search(H - target + 1, top, N);
            min = Math.min(min, bottomCount + topCount);
            map.put(bottomCount + topCount, map.getOrDefault(bottomCount + topCount, 0) + 1);
        }

        System.out.print(min + " " + map.get(min));
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