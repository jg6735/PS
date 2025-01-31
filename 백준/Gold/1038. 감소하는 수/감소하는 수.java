import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        int N = Integer.parseInt(in.readLine());
        if (N > 1022) {
            System.out.print(-1);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            dfs(i, i);
        }

        Collections.sort(list);
        System.out.print(list.get(N));
    }

    static void dfs(long num, int last) {
        list.add(num);
        for (int i = 0; i < last; i++) {
            dfs(num * 10 + i, i);
        }
    }
}