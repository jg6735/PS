import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] sArr = in.readLine().toCharArray();
        char[] tArr = in.readLine().toCharArray();
        int sLen = sArr.length;
        int tLen = tArr.length;
        int[][] dp = new int[sLen + 1][tLen + 1];
        int max = 0;
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (sArr[i - 1] == tArr[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.print(max);
    }
}