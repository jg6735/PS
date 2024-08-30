import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int six = 1001;
        int one = 1001;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            six = Math.min(six, Integer.parseInt(st.nextToken()));
            one = Math.min(one, Integer.parseInt(st.nextToken()));
        }

        int answer = 0;
        if (one * 6 < six) {
            answer = one * N;
        } else {
            answer = six * (N / 6);
            answer += Math.min(N % 6 * one, six);
        }

        System.out.print(answer);
    }
}