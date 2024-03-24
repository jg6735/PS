import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, M;
    private static int[] arr, numbers;
    private static boolean[] isSelected;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Arrays.sort(arr);
        dfs(0, 0);
    }

    private static void dfs(int cnt, int start) {
        if (cnt == M) {
            for (int number : numbers) {
                builder.append(number).append(" ");
            }

            builder.append("\n");
            return;
        }

        int prev = 0;
        for (int i = start; i < N; i++) {
            if (isSelected[i]) {
                continue;
            }

            if (prev == arr[i]) {
                continue;
            }

            prev = arr[i];
            isSelected[i] = true;
            numbers[cnt] = arr[i];
            dfs(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        numbers = new int[M];
        isSelected = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}