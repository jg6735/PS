import java.io.*;
import java.util.ArrayList;
import java.util.List;
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
        List<int[]> list = new ArrayList<>();
        int size = Math.min(N, M) / 2;
        for (int i = 0; i < size; i++) {
            int[] temp = new int[(N - i * 2) * 2 + (M - i * 2 - 2) * 2];
            int r = i;
            int c = i;
            int d = 0;
            temp[0] = arr[r][c];
            for (int j = 1; j < temp.length; j++) {
                int nextR = r + DR[d];
                int nextC = c + DC[d];

                if (nextR < i || nextC < i || nextR >= N - i || nextC >= M - i) {
                    d = (d + 1) % 4;
                    nextR = r + DR[d];
                    nextC = c + DC[d];
                }

                temp[j] = arr[nextR][nextC];
                r = nextR;
                c = nextC;
            }

            list.add(temp);
        }

        int[][] result = new int[N][M];
        for (int i = 0; i < list.size(); i++) {
            int[] temp = list.get(i);
            int cnt = R % temp.length;
            int[] newArr = new int[temp.length];
            for (int j = 0; j < temp.length; j++) {
                newArr[j] = temp[(j + cnt) % temp.length];
            }

            int r = i;
            int c = i;
            int d = 0;
            result[r][c] = newArr[0];
            for (int j = 1; j < temp.length; j++) {
                int nextR = r + DR[d];
                int nextC = c + DC[d];

                if (nextR < i || nextC < i || nextR >= N - i || nextC >= M - i) {
                    d = (d + 1) % 4;
                    nextR = r + DR[d];
                    nextC = c + DC[d];
                }

                result[nextR][nextC] = newArr[j];
                r = nextR;
                c = nextC;
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                builder.append(result[r][c]).append(" ");
            }
            builder.append("\n");
        }
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