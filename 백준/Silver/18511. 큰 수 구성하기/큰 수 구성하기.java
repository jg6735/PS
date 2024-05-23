import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, K, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[K];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        recursion(0);
        System.out.print(answer);
    }

    static void recursion(int number) {
        if (number > N) {
            return;
        }

        answer = Math.max(answer, number);
        for (int i = K - 1; i >= 0; i--) {
            recursion(number * 10 + arr[i]);
        }
    }
}