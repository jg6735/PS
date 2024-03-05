import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, answer;
    private static int[][] arr;
    private static boolean[] isSelected;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        dfs(0, 0);
    }

    private static void dfs(int depth, int start) {
        if (depth == N / 2) {
            getDiff();
            if (answer == 0) {
                System.out.println(answer);
                System.exit(0);
            }

            return;
        }

        for (int i = start; i < N; i++) {
            isSelected[i] = true;
            dfs(depth + 1, i + 1);
            isSelected[i] = false;
        }
    }

    private static void getDiff() {
        int start = 0;
        int link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isSelected[i] && isSelected[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (!isSelected[i] && !isSelected[j]){
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }


        answer = Math.min(Math.abs(start - link), answer);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][N];
        isSelected = new boolean[N];
        answer = Integer.MAX_VALUE;
        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}