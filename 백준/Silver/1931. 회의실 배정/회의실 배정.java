import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static List<Meeting> result;
    private static Meeting[] meetings;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Arrays.sort(meetings);
        result.add(meetings[0]);
        for (int i = 1; i < N; i++) {
            if (result.get(result.size() - 1).getEnd() <= meetings[i].getStart()) {
                result.add(meetings[i]);
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        meetings = new Meeting[N];
        result = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(result.size()));
        out.flush();
    }

    private static class Meeting implements Comparable<Meeting> {
        private final int start;
        private final int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Meeting o) {
            return end == o.getEnd() ? start - o.getStart() : end - o.getEnd();
        }
    }
}