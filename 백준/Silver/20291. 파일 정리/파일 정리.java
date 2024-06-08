import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String str = in.readLine().split("\\.")[1];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            builder.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        System.out.print(builder);
    }
}