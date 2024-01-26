import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, B, maxH, minH;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int answerCount = Integer.MAX_VALUE;
        int answerHeight = 0;
        for (int height = minH; height <= maxH; height++) {
            int count = 0;
            int block = B;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (count > answerCount) {
                        continue;
                    }

                    int diff = map[r][c] - height;
                    if (diff > 0) {
                        count += diff * 2;
                        block += diff;
                    } else {
                        count -= diff;
                        block += diff;
                    }
                }
            }

            if (block < 0) {
                break;
            }

            if (answerCount >= count) {
                answerCount = count;
                answerHeight = height;
            }
        }

        builder.append(answerCount).append(" ").append(answerHeight);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        maxH = 0;
        minH = 256;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
                minH = Math.min(minH, map[i][j]);
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
        close();
    }

    private static void close() throws IOException {
        out.close();
        in.close();
    }
}