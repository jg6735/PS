import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] sumAB = new int[n * n];
        int[] sumCD = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumAB[i * n + j] = A[i] + B[j];
                sumCD[i * n + j] = C[i] + D[j];
            }
        }

        Arrays.sort(sumAB);
        Arrays.sort(sumCD);
        long answer = 0;
        int left = 0;
        int right = n * n - 1;
        while (left < n * n && right >= 0) {
            int sum = sumAB[left] + sumCD[right];
            if (sum == 0) {
                long countAB = 1;
                long countCD = 1;
                while (left + 1 < n * n && sumAB[left] == sumAB[left + 1]) {
                    left++;
                    countAB++;
                }

                while (right - 1 >= 0 && sumCD[right] == sumCD[right - 1]) {
                    right--;
                    countCD++;
                }

                answer += countAB * countCD;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.print(answer);
    }
}