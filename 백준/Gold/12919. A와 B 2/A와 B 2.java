import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String S, T;
    static boolean canTransfer;
    static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        S = in.readLine();
        T = in.readLine();
        builder = new StringBuilder(S);
        transfer(T);
        System.out.print(canTransfer ? 1 : 0);
    }

    static void transfer(String str) {
        if (canTransfer) {
            return;
        }

        if (str.equals(S)) {
            canTransfer = true;
            return;
        }

        if (str.length() < S.length()) {
            return;
        }

        if (str.charAt(str.length() - 1) == 'A') {
            transfer(str.substring(0, str.length() - 1));
        }

        if (str.charAt(0) == 'B') {
            transfer(new StringBuilder(str.substring(1)).reverse().toString());
        }
    }
}