import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int H, W, answer;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] == 0) {
                    search(r, c);
                }
            }
        }
    }

    private static void search(int curR, int curC) {
        boolean hasLeftBlock = findLeftBlock(curR, curC);
        boolean hasRightBlock = findRightBlock(curR, curC);

        int nextC = curC;
        if (!hasLeftBlock) {
            map[curR][nextC] = -1;
            while (nextC + 1 < W && map[curR][nextC + 1] != 1) {
                map[curR][++nextC] = -1;
            }
        }

        if (!hasRightBlock) {
            map[curR][curC] = -1;
            while (curC + 1 < W) {
                map[curR][++curC] = -1;
            }
        }

        if (hasLeftBlock && hasRightBlock) {
            map[curR][curC] = 2;
            answer++;
            while (map[curR][curC + 1] != 1) {
                map[curR][++curC] = 2;
                answer++;
            }
        }
    }

    private static boolean findRightBlock(int curR, int curC) {
        boolean hasRightBlock = false;
        for (int c = curC; c < W; c++) {
            if (c + 1 < W && map[curR][c + 1] == 1) {
                hasRightBlock = true;
                break;
            }
        }

        return hasRightBlock;
    }

    private static boolean findLeftBlock(int curR, int curC) {
        boolean hasLeftBlock = false;
        for (int c = curC; c >= 0; c--) {
            if (c - 1 >= 0 && map[curR][c - 1] == 1) {
                hasLeftBlock = true;
                break;
            }
        }

        return hasLeftBlock;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];

        st = new StringTokenizer(in.readLine());
        for (int c = 0; c < W; c++) {
            int max = Integer.parseInt(st.nextToken());
            for (int r = 0; r < max; r++) {
                map[H - r - 1][c] = 1;
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}