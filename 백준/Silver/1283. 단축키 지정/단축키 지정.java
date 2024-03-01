import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    private static int N;
    private static Set<Character> set;

    private static BufferedReader in;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (N-- > 0) {
            String input = in.readLine();
            String[] arr = input.split(" ");
            boolean check = false;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                String str = arr[i];
                char c = str.charAt(0);
                if (!check && !set.contains(c)) {
                    set.add(c);
                    set.add(Character.toLowerCase(c));
                    set.add(Character.toUpperCase(c));
                    sb.append("[")
                            .append(c)
                            .append("]")
                            .append(str.substring(1))
                            .append(" ");

                    check = true;
                } else {
                    sb.append(str)
                            .append(" ");
                }
            }

            if (check) {
                builder.append(sb)
                        .append("\n");
            } else {
                sb = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    char c = input.charAt(i);
                    if (c == ' ') {
                        sb.append(' ');
                        continue;
                    }

                    if (set.contains(c)) {
                        sb.append(c);
                    } else {
                        set.add(c);
                        set.add(Character.toUpperCase(c));
                        set.add(Character.toLowerCase(c));
                        sb.append("[")
                                .append(c)
                                .append("]")
                                .append(input.substring(i + 1));
                        break;
                    }
                }

                builder.append(sb)
                        .append("\n");
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        N = Integer.parseInt(in.readLine());
        set = new HashSet<>();
    }

    private static void print() {
        System.out.println(builder);
    }
}