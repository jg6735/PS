import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int diff = y - x;
            int root = (int) Math.sqrt(diff);
            int result;
            if (root * root == diff) {
                result = root * 2 - 1;
            } else if (root * root + root >= diff) {
                result = root * 2;
            } else {
                result = root * 2 + 1;
            }

            builder.append(result).append("\n");
        }

        System.out.print(builder);
    }
}