import java.io.*;

public class Main {

    private static final int[] ARR = {1, 5, 10, 50};

    private static int N, answer;
    private static boolean[] visited;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        recursion(0, 0, 0);
    }

    private static void recursion(int cnt, int idx, int sum) {
        if (cnt == N) {
            if (!visited[sum]) {
                visited[sum] = true;
                answer++;
            }

            return;
        }

        for (int i = idx; i < 4; i++) {
            recursion(cnt + 1, i, sum + ARR[i]);
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        visited = new boolean[1001];
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}