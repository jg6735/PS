import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int k;
    private static List<String> result;
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
        for (int i = 0; i < 10; i++) {
            isSelected = new boolean[10];
            isSelected[i] = true;
            dfs(0, i, Integer.toString(i));
            isSelected[i] = false;
        }

        Collections.sort(result);
        builder.append(result.get(result.size() - 1)).append("\n").append(result.get(0));
    }

    private static void dfs(int cnt, int start, String num) {
        if (num.length() == k + 1) {
            result.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (isSelected[i]) {
                continue;
            }

            char op = ops[cnt];
            if (op == '>') {
                if (start > i) {
                    isSelected[i] = true;
                    dfs(cnt + 1, i, num + i);
                    isSelected[i] = false;
                }
            } else {
                if (start < i) {
                    isSelected[i] = true;
                    dfs(cnt + 1, i, num + i);
                    isSelected[i] = false;
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        k = Integer.parseInt(in.readLine());
        result = new ArrayList<>();
        ops = new char[k];
        isSelected = new boolean[10];
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