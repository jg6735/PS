import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int A, T, N;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(in.readLine());
        T = Integer.parseInt(in.readLine());
        N = Integer.parseInt(in.readLine());
        System.out.print(solve());
    }

    static int solve() {
        int bCnt = 0;
        int dCnt = 0;
        int start = 2;
        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    bCnt++;
                } else {
                    dCnt++;
                }

                if (N == 0 && bCnt == T) {
                    return (bCnt + dCnt - 1) % A;
                }

                if (N == 1 && dCnt == T) {
                    return (bCnt + dCnt - 1) % A;
                }
            }

            for (int i = 0; i < start; i++) {
                if (++bCnt == T && N == 0) {
                    return (bCnt + dCnt - 1) % A;
                }
            }

            for (int i = 0; i < start; i++) {
                if (++dCnt == T && N == 1) {
                    return (bCnt + dCnt - 1) % A;
                }
            }
            
            start++;
        }
    }
}