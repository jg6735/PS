import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {1, 0, -1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, M, K, answer;
    private static int[][] arr, op;
    private static int[] result;
    private static boolean[] isSelected;

    private static BufferedReader in;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        dfs(0);
    }

    private static void dfs(int cnt) {
        if (cnt == K) {
            int[][] copied = copyArr(arr);
            for (int idx : result) {
                rotate(op[idx], copied);
            }

            getRowMin(copied);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (isSelected[i]) {
                continue;
            }

            isSelected[i] = true;
            result[cnt] = i;
            dfs(cnt + 1);
            isSelected[i] = false;
        }
    }

    private static void getRowMin(int[][] copied) {
        for (int r = 0; r < N; r++) {
            int sum = 0;
            for (int c = 0; c < M; c++) {
                sum += copied[r][c];
            }

            answer = Math.min(sum, answer);
        }
    }

    private static int[][] copyArr(int[][] original) {
        int[][] copied = new int[N][M];
        for (int r = 0; r < N; r++) {
            System.arraycopy(original[r], 0, copied[r], 0, M);
        }

        return copied;
    }

    private static void rotate(int[] op, int[][] copied) {
        int r = op[0];
        int c = op[1];
        int s = op[2];

        int startR = r - s - 1;
        int startC = c - s - 1;
        int endR = r + s;
        int endC = c + s;
        int curR = startR;
        int curC = startC;
        int start = copied[curR][curC];
        int count = (endR - startR) / 2;
        int dir = 0;
        while (count > 0) {
            if (curR + DR[dir] >= endR || curC + DC[dir] >= endC || curR + DR[dir] < startR || curC + DC[dir] < startC) {
                dir++;
            }

            int nextR = curR + DR[dir];
            int nextC = curC + DC[dir];
            copied[curR][curC] = copied[nextR][nextC];
            if (nextR == startR && nextC == startC) {
                copied[curR][curC] = start;
                startR++;
                startC++;
                endR--;
                endC--;
                curR = startR;
                curC = startC;
                dir = 0;
                count--;
                start = copied[curR][curC];
                continue;
            }

            curR = nextR;
            curC = nextC;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        op = new int[K][3];
        isSelected = new boolean[K];
        result = new int[K];
        answer = Integer.MAX_VALUE;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            op[i][0] = Integer.parseInt(st.nextToken());
            op[i][1] = Integer.parseInt(st.nextToken());
            op[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() {
        System.out.println(answer);
    }
}