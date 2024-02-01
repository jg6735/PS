import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    private static int N, answer = 4;
    private static int[] arr;
    private static Set<Integer> set;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < N - 1; i++) {
            int cnt = 1;
            for (int j = arr[i] + 1; j < arr[i] + 5; j++) {
                if (set.contains(j)) {
                    cnt++;
                }
            }

            answer = Math.min(answer, 5 - cnt);
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.readLine());
            set.add(arr[i]);
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}