import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, S, R, answer;
    private static int[] arr, broken;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Arrays.sort(broken);
        for (int i = 0; i < S; i++) {
            int brokenTeam = broken[i] - 1;
            if (arr[brokenTeam] >= 1) {
                arr[brokenTeam]--;
            } else {
                if (brokenTeam > 1 && arr[brokenTeam - 1] > 1) {
                    arr[brokenTeam - 1]--;
                } else if (brokenTeam < N - 1 && arr[brokenTeam + 1] > 1) {
                    arr[brokenTeam + 1]--;
                } else {
                    answer++;
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        broken = new int[S];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = 1;
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < S; i++) {
            int team = Integer.parseInt(st.nextToken());
            broken[i] = team;
            arr[team - 1] = 0;
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < R; i++) {
            int team = Integer.parseInt(st.nextToken());
            arr[team - 1]++;
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}