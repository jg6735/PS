import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, 1, 0, -1};
    private static final int[] DC = {1, 0, -1, 0};

    private static int N, M, R;
    private static int[][] arr;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int[][] result = new int[N][M];
        int size = Math.min(N, M) / 2;
        for (int i = 0; i < size; i++) {
            rotate(i, result);
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                builder.append(result[r][c]).append(" ");
            }
            builder.append("\n");
        }
    }

    private static void rotate(int i, int[][] result) {
        int[] array = new int[(N + M - i * 4 - 2) * 2];
        int length = array.length;
        int cnt = R % length;
        int[] dirs = new int[]{i, i, 0};
        for (int j = 0; j < length; j++) {
            array[(j - cnt + length) % length] = arr[dirs[0]][dirs[1]];
            rotateNumber(i, dirs);
        }
        
        for (int number : array) {
            result[dirs[0]][dirs[1]] = number;
            rotateNumber(i, dirs);
        }
    }

    private static void rotateNumber(int i, int[] dirs) {
        int nextR = dirs[0] + DR[dirs[2]];
        int nextC = dirs[1] + DC[dirs[2]];
        if (isOutside(i, nextR, nextC)) {
            dirs[2] = (dirs[2] + 1) % 4;
            nextR = dirs[0] + DR[dirs[2]];
            nextC = dirs[1] + DC[dirs[2]];
        }

        dirs[0] = nextR;
        dirs[1] = nextC;
    }

    private static boolean isOutside(int i, int nextR, int nextC) {
        return nextR < i || nextC < i || nextR >= N - i || nextC >= M - i;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}