import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        String input = "";
        while ((input = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int answer = 0;
            for (int i = N; i <= M; i++) {
                Set<Character> set = new HashSet<>();
                String number = Integer.toString(i);
                for (int j = 0; j < number.length(); j++) {
                    set.add(number.charAt(j));
                }

                if (set.size() == number.length()) {
                    answer++;
                }
            }

            builder.append(answer).append("\n");
        }

        System.out.println(builder);
    }
}