import java.io.*;

public class Main {

    private static final int[] DR = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static final int[] DC = {-1, 0, 1, 1, 1, 0, -1, -1};

    private static int N;
    private static char[][] map;
    private static int[][] result;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 숫자인 경우(주변 지뢰의 개수)
                if (Character.isDigit(map[i][j])) {
                    // 지뢰 찾기 맵 작성
                    setMineMap(i, j);
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (result[i][j] == -1) {
                    builder.append("*");
                } else if (result[i][j] >= 10) {
                    builder.append("M");
                } else {
                    builder.append(result[i][j]);
                }
            }

            builder.append("\n");
        }
    }

    private static void setMineMap(int i, int j) {
        // 지뢰 숫자칸은 -1로 초기화
        result[i][j] = -1;

        // 8방 탐색
        for (int d = 0; d < 8; d++) {
            int nextR = i + DR[d];
            int nextC = j + DC[d];

            // 배열 범위 이내고 숫자칸이 아닌 경우, 인접한 칸에 지뢰의 개수만큼 더하기
            if (isAvailable(nextR, nextC) && !Character.isDigit(map[nextR][nextC])) {
                result[nextR][nextC] += map[i][j] - '0';
            }
        }
    }

    private static boolean isAvailable(int nextR, int nextC) {
        return nextR >= 0 && nextC >= 0 && nextR < N && nextC < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        result = new int[N][N];
        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = input.charAt(j);
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
        close();
    }

    private static void close() throws IOException {
        out.close();
        in.close();
    }
}