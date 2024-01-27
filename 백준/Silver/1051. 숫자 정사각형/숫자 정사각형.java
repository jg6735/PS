import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, answer;
    private static int[][] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < M - 1; j++) {
                int leftUp = arr[i][j];
                for (int k = i + 1; k < N; k++) {
                    int leftDown = arr[k][j];
                    int diff = k - i;
                    if (leftUp == leftDown && j + diff >= 0 && j + diff < M) {
                        int rightUp = arr[i][j + diff];
                        int rightDown = arr[k][j + diff];

                        if (leftUp == rightUp && leftDown == rightDown) {
                            answer = Math.max((int) Math.pow(k - i + 1, 2), answer);
                        }
                    }
                }
            }
        }

        if (answer == 0) {
            answer = 1;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}