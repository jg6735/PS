import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, -1, 0, 1};
    private static final int[] DC = {1, 0, -1, 0};

    private static int R, C, T, answer;
    private static AirCleaner airCleaner;
    private static int[][] map;
    private static boolean[][] check;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        while (T-- > 0) {
            checkSpread();
            clean();
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != -1) {
                    answer += map[r][c];
                }
            }
        }
    }

    private static void checkSpread() {
        int[][] temp = copyMap();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (hasDust(map[r][c])) {
                    int spreadCount = spread(r, c, temp[r][c] / 5);
                    map[r][c] -= (int) (Math.floor((double) temp[r][c] / 5) * spreadCount);
                }
            }
        }
    }

    private static int[][] copyMap() {
        int[][] temp = new int[R][C];
        for (int r = 0; r < R; r++) {
            System.arraycopy(map[r], 0, temp[r], 0, C);
        }
        return temp;
    }

    private static int spread(int r, int c, int dust) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int nextR = r + DR[d];
            int nextC = c + DC[d];

            if (isAvailable(nextR, nextC) && map[nextR][nextC] != -1) {
                map[nextR][nextC] += dust;
                count++;
            }
        }

        return count;
    }

    private static void clean() {
        int topR = airCleaner.getTopRow();
        int topC = airCleaner.getTopCol();
        int bottomR = airCleaner.getBottomRow();
        int bottomC = airCleaner.getBottomCol();

        int[][] temp = copyMap();
        temp[topR][topC] = 0;
        temp[bottomR][bottomC] = 0;

        int nextTopR = topR;
        int nextTopC = topC;
        int nextBottomR = bottomR;
        int nextBottomC = bottomC;
        for (int d = 0; d < 4; d++) {
            while (isAvailable(nextTopR + DR[d], nextTopC + DC[d])) {
                if (nextTopR + DR[d] == topR && nextTopC + DC[d] == topC) {
                    map[topR][topC] = -1;
                    break;
                }

                map[nextTopR + DR[d]][nextTopC + DC[d]] = temp[nextTopR][nextTopC];
                nextTopR += DR[d];
                nextTopC += DC[d];
            }

            int dir = d % 2 == 1 ? (d + 2) % 4 : d;
            while (isAvailable(nextBottomR + DR[dir], nextBottomC + DC[dir])) {
                if (nextBottomR + DR[dir] == bottomR && nextBottomC + DC[dir] == bottomC) {
                    map[bottomR][bottomC] = -1;
                    break;
                }

                map[nextBottomR + DR[dir]][nextBottomC + DC[dir]] = temp[nextBottomR][nextBottomC];
                nextBottomR += DR[dir];
                nextBottomC += DC[dir];
            }
        }
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static boolean hasDust(int dust) {
        return dust > 0;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        check = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] > 0) {
                    check[r][c] = true;
                } else if (airCleaner == null && map[r][c] == -1) {
                    airCleaner = new AirCleaner(r, c, r + 1, c);
                }
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }

    private static class AirCleaner {
        private final int topRow;
        private final int topCol;
        private final int bottomRow;
        private final int bottomCol;

        public AirCleaner(int topRow, int topCol, int bottomRow, int bottomCol) {
            this.topRow = topRow;
            this.topCol = topCol;
            this.bottomRow = bottomRow;
            this.bottomCol = bottomCol;
        }

        public int getTopRow() {
            return topRow;
        }

        public int getTopCol() {
            return topCol;
        }

        public int getBottomRow() {
            return bottomRow;
        }

        public int getBottomCol() {
            return bottomCol;
        }
    }
}