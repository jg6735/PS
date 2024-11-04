import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < N) {
            while (set.contains(arr[right])) {
                set.remove(arr[left]);
                left++;
            }

            set.add(arr[right]);
            answer += (right - left + 1);
            right++;
        }

        System.out.print(answer);
    }
}