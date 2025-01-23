import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, String> parent;
    static Map<String, Integer> size;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            parent = new HashMap<>();
            size = new HashMap<>();

            int F = Integer.parseInt(in.readLine());
            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                // 최초에는 자기 자신을 루트로 저장
                parent.computeIfAbsent(a, key -> key);
                parent.computeIfAbsent(b, key -> key);
                // 최초에는 집합의 크기는 1
                size.computeIfAbsent(a, key -> 1);
                size.computeIfAbsent(b, key -> 1);

                union(a, b);
                builder.append(size.get(find(a))).append("\n");
            }
        }

        System.out.print(builder);
    }

    static String find(String x) {
        if (!parent.get(x).equals(x)) {
            // 경로 압축을 통해 효율성 증대
            parent.put(x, find(parent.get(x)));
        }

        return parent.get(x);
    }

    static void union(String x, String y) {
        String rootX = find(x);
        String rootY = find(y);

        if (!rootX.equals(rootY)) {
            // x의 네트워크가 더 크면 y를 x에 병합
            if (size.get(rootX) > size.get(rootY)) {
                parent.put(rootY, rootX);
                size.put(rootX, size.get(rootX) + size.get(rootY));
            } else { // y의 네트워크가 더 크면 x를 y에 병합
                parent.put(rootX, rootY);
                size.put(rootY, size.get(rootX) + size.get(rootY));
            }
        }
    }
}