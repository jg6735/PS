import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int MIN = 123;
    private static final int MAX = 987;

    private static int N, answer;
    private static boolean[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        for (int i = MIN; i <= MAX; i++) {
            String number = Integer.toString(i);
            
            if (!number.contains("0") && isDifferentPlace(number)) {
                arr[i] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            String question = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int n = MIN; n <= MAX; n++) {
                if (arr[n]) {
                    int strikeCnt = 0;
                    int ballCnt = 0;
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            String number = Integer.toString(n);
                            if (isSameNumber(question, a, number, b) && a == b) {
                                strikeCnt++;
                            } else if (isSameNumber(question, a, number, b) && a != b) {
                                ballCnt++;
                            }
                        }
                    }

                    if (strike == strikeCnt && ball == ballCnt) {
                        arr[n] = true;
                    } else {
                        arr[n] = false;
                    }
                }
            }
        }

        for (int i = MIN; i <= MAX; i++) {
            if (arr[i]) {
                answer++;
            }
        }
    }

    private static boolean isSameNumber(String str1, int place1, String str2, int place2) {
        return str1.charAt(place1) == str2.charAt(place2);
    }

    private static boolean isDifferentPlace(String number) {
        return number.charAt(0) != number.charAt(1) && number.charAt(1) != number.charAt(2) && number.charAt(0) != number.charAt(2);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new boolean[MAX + 1];
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}