import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int answer = 0;
        int size = arr.length;
        int[] temp = new int[100_001];
        while (end < size) {
            while (end < size && temp[arr[end]] + 1 <= K) {
                temp[arr[end++]]++;
            }

            int length = end - start;
            answer = Math.max(answer, length);
            temp[arr[start++]]--;
        }

        System.out.print(answer);
    }
}