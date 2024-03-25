import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int L, C;
    private static char[] arr, result;

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
        if (cnt == L) {
            int vowelCount = 0;
            int other = 0;
            for (int i = 0; i < L; i++) {
                char c = result[i];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                } else {
                    other++;
                }
            }

            if (vowelCount >= 1 && other >= 2) {
                for (int i = 0; i < L; i++) {
                    builder.append(result[i]);
                }

                builder.append("\n");
            }

            return;
        }

        for (int i = start; i < C; i++) {
            result[cnt] = arr[i];
            dfs(cnt + 1, i + 1);
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        result = new char[L];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}