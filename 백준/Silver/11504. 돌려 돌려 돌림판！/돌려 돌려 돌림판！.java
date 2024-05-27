import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        StringBuilder builder = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] board = new int[N];
            int X = 0;
            int Y = 0;
            int answer = 0;
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                X += Integer.parseInt(st.nextToken()) * (int) Math.pow(10, M - 1 - i);
            }
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                Y += Integer.parseInt(st.nextToken()) * (int) Math.pow(10, M - 1 - i);
            }

            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) {
                board[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                int Z = 0;
                int ex = M;
                int cnt = 0;
                for (int j = i; cnt < i + M; j++, cnt++) {
                    if (j >= N) {
                        j = 0;
                    }

                    Z += board[j] * (int) Math.pow(10, --ex);
                }

                if (Z >= X && Z <= Y) {
                    answer++;
                }
            }

            builder.append(answer).append("\n");
        }

        System.out.print(builder);
    }
}