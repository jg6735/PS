import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int[] numbers;
    private static boolean[] arr;
    private static int answer;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int number = getMinNumber(numbers);
        for (int i = 1111; i <= number; i++) {
            arr[i] = check(i);
            if (arr[i]) {
                answer++;
            }
        }
    }

    private static int getMinNumber(int[] arr) {
        int min = 10000;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, arr[i] * 1000 + arr[(i + 1) % 4] * 100 + arr[(i + 2) % 4] * 10 + arr[(i + 3) % 4]);
        }

        return min;
    }

    private static boolean check(int number) {
        int[] numbers = new int[4];
        for (int i = 0; i < 4; i++) {
            numbers[4 - i - 1] = number % 10;
            number /= 10;
        }

        int min = getMinNumber(numbers);
        if (min < 1000) {
            min *= 10;
        }

        if (arr[min] || min % 10 == 0 || min % 100 < 10 || min % 1000 < 100) {
            return false;
        }

        return true;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        numbers = new int[4];
        arr = new boolean[10000];

        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}