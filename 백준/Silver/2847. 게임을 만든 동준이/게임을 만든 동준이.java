import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
        }

        int max = levels[levels.length - 1];
        int answer = 0;
        for (int i = levels.length - 2; i >= 0; i--) {
            if (levels[i] > max) {
                max--;
                answer += (levels[i] - max);
            } else if (levels[i] == max) {
                max--;
                answer++;
            } else {
                max = levels[i];
            }
        }

        System.out.print(answer);
    }
}