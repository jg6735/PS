import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = n; i >= 0; i--) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] >= i) {
                    cnt++;
                }
            }
            
            if (cnt >= i) {
                System.out.print(i);
                return;
            }
        }
    }
}