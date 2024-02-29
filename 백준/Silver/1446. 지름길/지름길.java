import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, D;
    private static int[] dp;
    private static List<Path> list;

    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        list.sort((o1, o2) -> {
            if (o1.getStart() == o2.getStart()) {
                return o1.getEnd() - o2.getEnd();
            }

            return o1.getStart() - o2.getStart();
        });

        int idx = 0;
        int count = 0;
        while (count < D) {
            if (idx < list.size()) {
                Path cur = list.get(idx);
                if (count == cur.getStart()) {
                    dp[cur.getEnd()] = Math.min(dp[count] + cur.getDistance(), dp[cur.getEnd()]);
                    idx++;
                } else {
                    dp[count + 1] = Math.min(dp[count + 1], dp[count] + 1);
                    count++;
                }
            } else {
                dp[count + 1] = Math.min(dp[count + 1], dp[count] + 1);
                count++;
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        dp = new int[10001];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if (end <= D && end - start > distance) {
                list.add(new Path(start, end, distance));
            }
        }
    }

    private static void print() {
        System.out.println(dp[D]);
    }

    private static class Path {
        private final int start;
        private final int end;
        private final int distance;

        public Path(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getDistance() {
            return distance;
        }
    }
}