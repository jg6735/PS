import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int count;
    static List<Integer> list;
    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        for (int i = 0; i <= n; i++) {
            list = new ArrayList<>();
            list.add(n);
            list.add(i);
            recursion(n, i, n - i, 2);
        }

        System.out.println(count);
        System.out.print(builder);
    }

    static void recursion(int n, int i, int j, int cnt) {
        if (j < 0) {
            if (cnt > count) {
                count = cnt;

                builder = new StringBuilder();
                for (int number : list) {
                    builder.append(number).append(" ");
                }
            }
            return;
        }

        list.add(n - i);
        recursion(i, j, i - j, cnt + 1);
    }
}