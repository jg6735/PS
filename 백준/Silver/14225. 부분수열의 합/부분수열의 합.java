import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 100_000 * 20 + 1;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        boolean[] result = new boolean[SIZE];
        set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findMinSum(arr, result, N, 0, 0);
        int answer = 0;
        for (int i = 1; i < SIZE; i++) {
            if (!result[i]) {
                answer = i;
                break;
            }
        }

        System.out.print(answer);
    }

    static void findMinSum(int[] arr, boolean[] result, int N, int depth, int sum) {
        if (depth == N) {
            result[sum] = true;
            return;
        }

        findMinSum(arr, result, N, depth + 1, sum + arr[depth]);
        findMinSum(arr, result, N, depth + 1, sum);
    }
}