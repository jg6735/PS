import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static Set<String> enterSet;
    private static Set<String> leaveSet;
    private static int S, E, Q;
    private static int answer;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (String s : enterSet) {
            if (leaveSet.contains(s)) {
                answer++;
            }
        }
    }

    private static int strToTime(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(in.readLine());
        S = strToTime(st.nextToken());
        E = strToTime(st.nextToken());
        Q = strToTime(st.nextToken());
        enterSet = new HashSet<>();
        leaveSet = new HashSet<>();

        String input = "";
        while ((input = in.readLine()) != null) {
            st = new StringTokenizer(input);

            int time = strToTime(st.nextToken());
            String nickname = st.nextToken();

            if (time <= S) {
                enterSet.add(nickname);
            } else if (time >= E && time <= Q) {
                leaveSet.add(nickname);
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}