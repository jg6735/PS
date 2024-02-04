import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        int aAnswer = 0;
        int aCount = 0;
        int bAnswer = 0;
        int bCount = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int team = Integer.parseInt(st.nextToken());
            int time = strToIntTime(st.nextToken());

            if (aCount == 0 && bCount == 0) {
                if (team == 1) {
                    aCount++;
                } else {
                    bCount++;
                }
            } else if (team == 1) {
                if (aCount > bCount) {
                    aAnswer += time - prev;
                } else if (bCount > aCount) {
                    bAnswer += time - prev;
                }

                aCount++;
            } else if (team == 2) {
                if (aCount > bCount) {
                    aAnswer += time - prev;
                } else if (bCount > aCount) {
                    bAnswer += time - prev;
                }

                bCount++;
            }

            prev = time;
        }

        int endTime = strToIntTime("48:00");
        if (aCount > bCount) {
            aAnswer += endTime - prev;
        } else if (bCount > aCount) {
            bAnswer += endTime - prev;
        }

        builder.append(intToStringTime(aAnswer)).append("\n").append(intToStringTime(bAnswer));
    }

    private static int strToIntTime(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }

    private static String intToStringTime(int time) {
        StringBuilder sb = new StringBuilder();
        int hour = time / 60;
        int minute = time % 60;
        if (hour < 10) {
            sb.append("0");
        }
        sb.append(hour).append(":");
        if (minute < 10) {
            sb.append("0");
        }
        sb.append(minute);
        return sb.toString();
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        N = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}