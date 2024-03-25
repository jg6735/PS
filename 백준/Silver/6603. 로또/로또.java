import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        String input = "";
        while (!(input = in.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            int[] result = new int[6];
            boolean[] isSelected = new boolean[k];
            for (int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0, k, arr, result, isSelected);
            builder.append("\n");
        }
    }

    private static void dfs(int cnt, int start, int k, int[] arr, int[] result, boolean[] isSelected) {
        if (cnt == 6) {
            for (int number : result) {
                builder.append(number).append(" ");
            }

            builder.append("\n");
            return;
        }

        for (int i = start; i < k; i++) {
            if (isSelected[i]) {
                continue;
            }

            result[cnt] = arr[i];
            isSelected[i] = true;
            dfs(cnt + 1, i + 1, k, arr, result, isSelected);
            isSelected[i] = false;
        }
    }

    private static void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}