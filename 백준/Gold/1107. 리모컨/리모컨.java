import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int M = Integer.parseInt(in.readLine());
        Set<Integer> brokenNumPads = new HashSet<>();
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int i = 0; i < M; i++) {
                brokenNumPads.add(Integer.parseInt(st.nextToken()));
            }
        }

        if (N == 100) {
            System.out.print(0);
            return;
        }

        int min = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            String str = String.valueOf(i);
            boolean check = false;

            for (char c : str.toCharArray()) {
                if (brokenNumPads.contains(c - '0')) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                int count = str.length() + Math.abs(N - i);
                min = Math.min(min, count);
            }
        }

        System.out.print(min);
    }
}