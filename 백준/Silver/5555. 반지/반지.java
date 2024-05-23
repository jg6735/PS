import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int N = Integer.parseInt(in.readLine());
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            StringBuilder builder = new StringBuilder(in.readLine());
            builder.append(builder);
            if (builder.toString().contains(str)) {
                answer++;
            }
        }

        System.out.print(answer);
    }
}