import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] LEAP = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] NORMAL = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static String date;
    private static double answer;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        StringTokenizer st = new StringTokenizer(date);
        int month = monthToInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken().substring(0, 2));
        int year = Integer.parseInt(st.nextToken());
        String time = st.nextToken();
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));

        int totalSecond = 3600 * 24;
        if (isLeap(year)) {
            totalSecond *= 366;
        } else {
            totalSecond *= 365;
        }

        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            if (isLeap(year)) {
                sum += LEAP[i];
            } else {
                sum += NORMAL[i];
            }
        }

        sum = (sum + day - 1) * 3600 * 24 + hour * 3600 + min * 60;
        answer = ((double) sum / (double) totalSecond) * 100;
    }

    private static boolean isLeap(int year) {
        if (year % 400 == 0) {
            return true;
        } else {
            return year % 4 == 0 && year % 100 != 0;
        }
    }

    private static int monthToInt(String month) {
        switch (month) {
            case "January":
                return 1;
            case "February":
                return 2;
            case "March":
                return 3;
            case "April":
                return 4;
            case "May":
                return 5;
            case "June":
                return 6;
            case "July":
                return 7;
            case "August":
                return 8;
            case "September":
                return 9;
            case "October":
                return 10;
            case "November":
                return 11;
            case "December":
                return 12;
        }

        return 0;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        date = in.readLine();
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}