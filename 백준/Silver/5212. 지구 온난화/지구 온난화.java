import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int R, C;
    private static char[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        char[][] temp = new char[R][C];
        int maxR = 0;
        int maxC = 0;
        int minR = R;
        int minC = C;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'X') {
                    temp[r][c] = 'X';

                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nextR = r + DR[d];
                        int nextC = c + DC[d];

                        if (!isAvailable(nextR, nextC) || map[nextR][nextC] == '.') {
                            cnt++;
                        }
                    }

                    if (cnt >= 3) {
                        temp[r][c] = '.';
                    } else {
                        maxR = Math.max(maxR, r);
                        maxC = Math.max(maxC, c);
                        minR = Math.min(minR, r);
                        minC = Math.min(minC, c);
                    }
                } else {
                    temp[r][c] = '.';
                }

            }
        }

        for (int r = minR; r < maxR + 1; r++) {
            for (int c = minC; c < maxC + 1; c++) {
                builder.append(temp[r][c]);
            }

            builder.append("\n");
        }
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String input = in.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}