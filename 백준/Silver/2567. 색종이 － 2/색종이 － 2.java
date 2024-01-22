import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {0, 0, -1, 1};
    private static final int[] DY = {-1, 1, 0, 0};

    private static int N, answer;
    private static int[][] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int y = 0; y < 100; y++) {
            for (int x = 0; x < 100; x++) {
                if (arr[y][x] == 1) {
                    answer += getEdgeCount(x, y);
                }
            }
        }
    }

    private static int getEdgeCount(int x, int y) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nextX = x + DX[d];
            int nextY = y + DY[d];
            if (nextX < 0 || nextX >= 100 || nextY < 0 || nextY >= 100 || arr[nextY][nextX] == 0) {
                count++;
            }
        }

        return count;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[100][100];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    if (arr[j][k] == 0) {
                        arr[j][k]++;
                    }
                }
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}