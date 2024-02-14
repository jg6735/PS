import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, S, answer;
    private static int[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Arrays.sort(arr);
        search(0, 0);

        if (S == 0) {
            answer--;
        }
    }

    private static void search(int cnt, int sum) {
        if (cnt == N) {
            if (sum == S) {
                answer++;
            }

            return;
        }

        search(cnt + 1, sum);
        search(cnt + 1, arr[cnt] + sum);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}