import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, X, answer;
    static int[] levels;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        levels = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(levels);
        search(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        System.out.print(answer);
    }

    static void search(int depth, int count, int min, int max, long sum) {
        if (depth == N) {
            if (count >= 2 && sum >= L && sum <= R && max - min >= X) {
                answer++;
            }

            return;
        }

        search(depth + 1, count + 1, Math.min(min, levels[depth]), Math.max(max, levels[depth]),
            sum + levels[depth]);

        search(depth + 1, count, min, max, sum);
    }
}