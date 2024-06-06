import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            builder.append(map.get(in.readLine())).append("\n");
        }

        System.out.print(builder);
    }
}