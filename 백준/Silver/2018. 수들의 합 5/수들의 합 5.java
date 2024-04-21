import java.io.*;

public class Main {

    private static int N, answer;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int left = 1;
        int right = 1;
        int sum = 1;

        while (left <= right) {
            if (sum == N) {
                answer++;
            }

            if (sum < N) {
                sum += ++right;
            } else if (sum >= N) {
                sum -= left++;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}