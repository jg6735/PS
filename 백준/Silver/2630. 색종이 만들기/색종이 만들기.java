import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, white, blue;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0, N);
        StringBuilder builder = new StringBuilder();
        builder.append(white).append("\n").append(blue);
        System.out.print(builder);
    }

    static void recursion(int row, int col, int size) {
        if (checkColor(row, col, size)) {
            if (arr[row][col] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        size /= 2;
        recursion(row, col, size);
        recursion(row + size, col, size);
        recursion(row, col+ size, size);
        recursion(row + size, col + size, size);
    }

    static boolean checkColor(int row, int col, int size) {
        int color = arr[row][col];
        for (int r = row; r < row + size; r++) {
            for (int c = col; c < col + size; c++) {
                if (arr[r][c] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}