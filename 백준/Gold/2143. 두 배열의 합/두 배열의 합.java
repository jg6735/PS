import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        int n = Integer.parseInt(in.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(in.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> sumA = new ArrayList<>();
        List<Integer> sumB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumB);

        long answer = 0;
        for (int sum : sumA) {
            int t = T - sum;

            int lowerBound = lowerBound(sumB, t);
            int upperBound = upperBound(sumB, t);
            answer += upperBound - lowerBound;
        }

        System.out.print(answer);
    }

    private static int lowerBound(List<Integer> sumB, int t) {
        int left = 0;
        int right = sumB.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sumB.get(mid) < t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static int upperBound(List<Integer> sumB, int t) {
        int left = 0;
        int right = sumB.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sumB.get(mid) <= t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}