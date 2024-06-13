import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int first = arr[0];
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < N; i++) {
            int gcd = getGcd(first, arr[i]);
            builder.append(first / gcd).append("/").append(arr[i] / gcd).append("\n");
        }

        System.out.print(builder);
    }

    static int getGcd(int a, int b) {
        if (b <= 0) {
            return a;
        }

        return getGcd(b, a % b);
    }
}