import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] map = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxScore = Integer.MIN_VALUE;
        int minScore = Integer.MAX_VALUE;
        int[][] max = new int[N + 1][3];
        int[][] min = new int[N + 1][3];
        for (int i = N - 1; i >= 0; i--) {
            max[i][0] = map[i][0] + Math.max(max[i + 1][0], max[i + 1][1]);
            max[i][1] = map[i][1] + Math.max(Math.max(max[i + 1][0], max[i + 1][1]), max[i + 1][2]);
            max[i][2] = map[i][2] + Math.max(max[i + 1][1], max[i + 1][2]);
            min[i][0] = map[i][0] + Math.min(min[i + 1][0], min[i + 1][1]);
            min[i][1] = map[i][1] + Math.min(Math.min(min[i + 1][0], min[i + 1][1]), min[i + 1][2]);
            min[i][2] = map[i][2] + Math.min(min[i + 1][1], min[i + 1][2]);
        }

        for (int i = 0; i < 3; i++) {
            maxScore = Math.max(maxScore, max[0][i]);
            minScore = Math.min(minScore, min[0][i]);
        }

        System.out.print(maxScore + " " + minScore);
    }
}