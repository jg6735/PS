import java.io.*;

public class Main {

    private static int N, answer;
    private static String[] arr;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        String first = arr[0];
        for (int i = 1; i < N; i++) {
            String word = arr[i];

            int[] fArr = setAlphabetCountArray(first);
            int[] wArr = setAlphabetCountArray(word);
            int[] diff = new int['Z' + 1];
            int diffCount = 0;
            boolean check = false;
            for (int a = 'A'; a <= 'Z'; a++) {
                if (fArr[a] != wArr[a]) {
                    diff[a] = wArr[a] - fArr[a];
                    diffCount++;
                    if (Math.abs(diff[a]) >= 2) {
                        check = true;
                    }
                }
            }

            if (check || diffCount > 2 || Math.abs(word.length() - first.length()) >= 2) {
                answer--;
            }
        }
    }

    private static int[] setAlphabetCountArray(String str) {
        int[] arr = new int['Z' + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }

        return arr;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.readLine();
        }

        answer = N - 1;
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}