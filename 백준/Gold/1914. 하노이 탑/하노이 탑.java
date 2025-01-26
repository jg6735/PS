import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        StringBuilder builder = new StringBuilder();
        BigInteger total = BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE);
        builder.append(total).append("\n");
        if (N <= 20) {
            hanoi(N, 1, 2, 3, builder);
        }

        System.out.print(builder);
    }

    static void hanoi(int N, int from, int mid, int to, StringBuilder builder) {
        if (N == 0) {
            return;
        }

        hanoi(N - 1, from, to, mid, builder);
        builder.append(from).append(" ").append(to).append("\n");
        hanoi(N - 1, mid, from, to, builder);
    }
}