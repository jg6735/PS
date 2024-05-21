import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        String L = st.nextToken();
        String R = st.nextToken();
        
        if (L.length() != R.length()) {
            System.out.print(0);
        } else {
            int answer = 0;
            int idx = 0;
            while (idx < L.length() && L.charAt(idx) == R.charAt(idx)) {
                if (L.charAt(idx) == '8') {
                    answer++;
                }
                
                idx++;
            }

            System.out.print(answer);
        }
    }
}