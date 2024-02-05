import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static Deque<Homework> deque;
    private static int N, answer;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());

            Homework homework;
            if (hasHomework(st.nextToken())) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                homework = new Homework(score, time);
            } else {
                if (!deque.isEmpty()) {
                    homework = deque.pollFirst();
                } else {
                    continue;
                }
            }

            homework.doHomework();
            if (homework.getTime() == 0) {
                answer += homework.getScore();
            } else {
                deque.addFirst(homework);
            }
        }
    }

    private static boolean hasHomework(String input) {
        return Integer.parseInt(input) == 1;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        deque = new ArrayDeque<>();
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }

    private static class Homework {
        private final int score;
        private int time;

        public Homework(int score, int time) {
            this.score = score;
            this.time = time;
        }

        public int getScore() {
            return score;
        }

        public int getTime() {
            return time;
        }

        public void doHomework() {
            time--;
        }
    }
}