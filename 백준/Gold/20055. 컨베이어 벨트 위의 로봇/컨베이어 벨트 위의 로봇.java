import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, answer;
    private static int[] belt;
    private static boolean[] hasRobot;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        while (K > 0) {
            moveBelt();
            moveRobots();
            addRobot();
            answer++;
        }
    }

    private static void addRobot() {
        if (belt[0] > 0) {
            belt[0]--;
            checkDurability(0);
            hasRobot[0] = true;
        }
    }

    private static void moveBelt() {
        int last = belt[N * 2 - 1];
        for (int i = N * 2 - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last;

        for (int i = N - 1; i > 0; i--) {
            hasRobot[i] = hasRobot[i - 1];
        }

        hasRobot[0] = false;
        hasRobot[N - 1] = false;
    }

    private static void moveRobots() {
        for (int i = N - 1; i > 0; i--) {
            if (!hasRobot[i] && hasRobot[i - 1] && belt[i] > 0) {
                belt[i]--;
                checkDurability(i);
                hasRobot[i] = true;
                hasRobot[i - 1] = false;
            }
        }
    }

    private static void checkDurability(int i) {
        if (belt[i] == 0) {
            K--;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new int[N * 2];
        hasRobot = new boolean[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

}