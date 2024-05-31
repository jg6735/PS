import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final static int MOD = 1_000;
    static int N;
    static long B;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(arr, B);
        StringBuilder builder = new StringBuilder();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                builder.append(result[r][c]).append(" ");
            }
            builder.append("\n");
        }

        System.out.print(builder);
    }

    static int[][] pow(int[][] result, long ex) {
        if (ex == 1) {
            return result;
        }

        int[][] temp = pow(result, ex / 2);
        temp = mul(temp, temp);
        if (ex % 2 == 1) {
            temp = mul(temp, arr);
        }

        return temp;
    }

    static int[][] mul(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                for (int k = 0; k < N; k++) {
                    result[r][c] += a[r][k] * b[k][c];
                    result[r][c] %= MOD;
                }
            }
        }

        return result;
    }
}