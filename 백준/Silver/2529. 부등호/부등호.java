import java.io.*;

public class Main {

    private static int k;
    private static long max, min;
    private static int[] numbers;
    private static boolean[] isSelected;
    private static char[] ops;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        dfs(0);
        builder.append(max).append("\n");
        if (!String.valueOf(min).contains("0")) {
            builder.append(0);
        }
        builder.append(min);
    }

    private static void dfs(int cnt) {
        if (cnt == k + 1) {
            for (int i = 0; i < k; i++) {
                char op = ops[i];
                if (op == '>' && numbers[i] < numbers[i + 1]) {
                    return;
                }

                if (op == '<' && numbers[i] > numbers[i + 1]) {
                    return;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
                sb.append(number);
            }

            max = Math.max(Long.parseLong(sb.toString()), max);
            min = Math.min(Long.parseLong(sb.toString()), min);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isSelected[i]) {
                continue;
            }

            numbers[cnt] = i;
            isSelected[i] = true;
            dfs(cnt + 1);
            isSelected[i] = false;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        k = Integer.parseInt(in.readLine());
        numbers = new int[k + 1];
        ops = new char[k];
        isSelected = new boolean[10];
        max = Long.MIN_VALUE;
        min = Long.MAX_VALUE;
        String input = in.readLine();
        for (int i = 0, j = 0; i < k; i++, j += 2) {
            ops[i] = input.charAt(j);
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}