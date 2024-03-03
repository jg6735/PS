import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static PriorityQueue<Integer> pq;

    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                pq.add(Integer.parseInt(st.nextToken()));
                if (pq.size() > N) {
                    pq.poll();
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        pq = new PriorityQueue<>();
    }

    private static void print() {
        System.out.println(pq.poll());
    }
}