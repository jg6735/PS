import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int N, answer;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                search(r, c);
            }
        }
    }

    private static void search(int r, int c) {
        for (int d1 = 1; d1 <= N; d1++) {
            for (int d2 = 1; d2 <= N; d2++) {
                if (r + d1 + d2 <= N && c - d1 >= 1 && c + d2 <= N) {
                    int[][] result = new int[N + 1][N + 1];
                    divide(result, r, c, d1, d2);
                    getFive(r, d1, d2, result);
                    divideFour(r, c, d1, d2, result);
                    getMinDiff(result);
                }
            }
        }
    }

    private static void divide(int[][] result, int r, int c, int d1, int d2) {
        for (int i = 0; i <= d1; i++) {
            result[r + i][c - i] = 5;
        }

        for (int i = 0; i <= d2; i++) {
            result[r + i][c + i] = 5;
        }

        for (int i = 0; i <= d1; i++) {
            result[r + i + d2][c - i + d2] = 5;
        }

        for (int i = 0; i <= d2; i++) {
            result[r + i + d1][c + i - d1] = 5;
        }
    }

    private static void getFive(int r, int d1, int d2, int[][] result) {
        boolean check = false;
        for (int i = r + 1; i < r + d1 + d2; i++) {
            for (int j = 1; j <= N; j++) {
                if (check) {
                    if (result[i][j] == 5) {
                        check = false;
                        break;
                    }

                    result[i][j] = 5;
                }

                if (result[i][j] == 5) {
                    check = true;
                }
            }
        }
    }

    private static void divideFour(int r, int c, int d1, int d2, int[][] result) {
        for (int i = 1; i < r + d1; i++) {
            for (int j = 1; j <= c; j++) {
                if (result[i][j] != 5) {
                    result[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= r + d2; i++) {
            for (int j = c + 1; j <= N; j++) {
                if (result[i][j] != 5) {
                    result[i][j] = 2;
                }
            }
        }

        for (int i = r + d1; i <= N; i++) {
            for (int j = 1; j < c - d1 + d2; j++) {
                if (result[i][j] != 5) {
                    result[i][j] = 3;
                }
            }
        }

        for (int i = r + d2 + 1; i <= N; i++) {
            for (int j = c - d1 + d2; j <= N; j++) {
                if (result[i][j] != 5) {
                    result[i][j] = 4;
                }
            }
        }
    }

    private static void getMinDiff(int[][] result) {
        int[] sum = new int[5];
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                sum[result[r][c] - 1] += map[r][c];
            }
        }

        Arrays.sort(sum);
        answer = Math.min(answer, sum[4] - sum[0]);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());
        map = new int[N + 1][N + 1];
        answer = Integer.MAX_VALUE;
        for (int r = 1; r <= N; r++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int c = 1; c <= N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

}