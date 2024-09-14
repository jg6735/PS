import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        StringTokenizer st;

        int L, P, V, T = 1;
        while (true) {
            String input = br.readLine();
            st = new StringTokenizer(input);
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if (L == 0) {
                break;
            }

            int answer = V / P * L + Math.min(V % P, L);
            builder.append("Case ").append(T++).append(": ").append(answer).append("\n");
        }

        System.out.print(builder);
    }
}