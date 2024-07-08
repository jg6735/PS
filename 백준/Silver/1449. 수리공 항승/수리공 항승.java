import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] waterPoint = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            waterPoint[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(waterPoint);
        boolean[] water = new boolean[1001];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int start = waterPoint[i];
            if (!water[start]) {
                cnt++;
                for (int j = start; j < start + L; j++) {
                    if (j < water.length) {
                        water[j] = true;
                    } else {
                        break;
                    }
                }
            }
        }

        System.out.print(cnt);
    }
}