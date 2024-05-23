import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
                char[] arr = new char[10];
                String number = Integer.toString(i);
                boolean check = false;
                for (int j = 0; j < number.length(); j++) {
                    arr[number.charAt(j) - '0']++;
                    if (arr[number.charAt(j) - '0'] > 1) {
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    answer++;
                }
            }

            builder.append(answer).append("\n");
        }

        System.out.println(builder);
    }
}