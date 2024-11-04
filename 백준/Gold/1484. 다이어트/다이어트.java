import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(in.readLine());

        int count = 0;
        int left = 1;
        int right = 2;
        while (left < right) {
            long diff = (long) Math.pow(right, 2) - (long) Math.pow(left, 2);
            if (diff == G) {
                System.out.println(right);
                count++;
                left++;
                right++;
            } else if (diff < G) {
                right++;
            } else {
                left++;
            }
        }

        if (count == 0) {
            System.out.print(-1);
        }
    }
}