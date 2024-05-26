import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(in.readLine());
        int[][] classes = new int[number][5];
        for (int i = 0; i < number; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 5; j++) {
                classes[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int answer = 0;
        for (int i = 0; i < number; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < number; k++) {
                    if (i != k && classes[i][j] == classes[k][j]) {
                        set.add(k);
                    }
                }
            }

            if (set.size() > max) {
                max = set.size();
                answer = i;
            }
        }

        System.out.print(answer + 1);
    }
}