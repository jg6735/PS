import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        if (nextPermutation()) {
            for (int number : arr) {
                builder.append(number).append(" ");
            }
        } else {
            builder.append(-1);
        }
    }

    private static boolean nextPermutation() {
        int i = arr.length - 1;
        while (i > 0 && arr[i] > arr[i - 1]) {
            i--;
        }

        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[i - 1] < arr[j]) {
            j--;
        }

        swap(i - 1, j);
        j = arr.length - 1;
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    private static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        N = Integer.parseInt(in.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}