import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        boolean[] arr = new boolean[N + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = true;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            if (!arr[i]) {
                primes.add(i);
            }
        }

        int answer = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        while (left < primes.size()) {
            if (sum < N && right < primes.size()) {
                sum += primes.get(right);
                right++;
            } else {
                if (sum == N) {
                    answer++;
                }

                sum -= primes.get(left);
                left++;
            }
        }

        System.out.print(answer);
    }
}