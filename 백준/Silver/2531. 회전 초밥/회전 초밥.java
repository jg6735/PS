import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(in.readLine());
        }

        int[] counts = new int[d + 1]; // 종류별 개수 카운트
        int count = 0; // 부분 배열 내 종류 카운트
        int max = 0; // 최대 종류


        for (int i = 0; i < k; i++) {
            if (counts[belt[i]] == 0) {
                count++;
            }

            counts[belt[i]]++;
        }

        if (counts[c] == 0) {
            max = count + 1;
        } else {
            max = count;
        }

        for (int i = 1; i < N; i++) {
            // 이전 접시 제거
            int prev = belt[i - 1];
            counts[prev]--;
            if (counts[prev] == 0) {
                count--;
            }

            // 새 접시 추가
            int next = belt[(i + k - 1) % N]; // 회전 고려
            if (counts[next] == 0) {
                count++;
            }
            counts[next]++;

            // 쿠폰 적용
            int cur = 0;
            if (counts[c] == 0) {
                cur = count + 1;
            } else {
                cur = count;
            }

            max = Math.max(max, cur);
        }

        System.out.print(max);
    }
}