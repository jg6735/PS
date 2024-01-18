import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static List<Integer> list;
    private static int A, P, answer;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        list.add(A);

        int idx = 0;
        while (true) {
            int next = getSum(list.get(idx++));

            if (list.contains(next)) {
                answer = list.indexOf(next);
                break;
            }

            list.add(next);
        }
    }

    private static int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += (int) Math.pow(number % 10, P);
            number /= 10;
        }

        return sum;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));

        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}