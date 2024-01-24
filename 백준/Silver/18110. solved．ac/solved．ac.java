import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static int n, answer;
    private static int[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        if (n == 0) {
            return;
        } else if (n == 1) {
            answer = arr[0];
            return;
        }

        Arrays.sort(arr);
        int avg = (int) Math.round(n * 0.15);
        for (int i = avg; i < n - avg; i++) {
            answer += arr[i];
        }

        answer = Math.round((float) answer / (arr.length - avg * 2));
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(in.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in.readLine());
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}