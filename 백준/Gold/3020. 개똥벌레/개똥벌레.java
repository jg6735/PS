import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] bottom = new int[H + 1];
        int[] top = new int[H + 1];
        for (int i = 0; i < N / 2; i++) {
            bottom[Integer.parseInt(in.readLine())]++;
            top[Integer.parseInt(in.readLine())]++;
        }

        for (int h = H - 1; h >= 1; h--) {
            bottom[h] += bottom[h + 1];
            top[h] += top[h + 1];
        }

        int min = Integer.MAX_VALUE;
        int minCount = 0;

        for (int h = H; h >= 1; h--) {
            int bottomCount = bottom[h];
            int topCount = top[H - h + 1];
            int total = bottomCount + topCount;
            if (total < min) {
                min = total;
                minCount = 1;
            } else if (total == min) {
                minCount++;
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(min).append(" ").append(minCount);
        System.out.print(builder);
    }
}