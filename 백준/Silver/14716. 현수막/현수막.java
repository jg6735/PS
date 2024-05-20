import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] DR = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] DC = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[M][N];
        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        boolean[][] visited = new boolean[M][N];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && board[r][c] != 0) {
                    findWordCount(board, visited , M, N, r, c);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    static void findWordCount(int[][] board, boolean[][] visited, int row, int col, int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curRow = cur[0];
            int curCol = cur[1];

            for (int d = 0; d < 8; d++) {
                int nextRow = curRow + DR[d];
                int nextCol = curCol + DC[d];

                if (nextRow < 0 || nextRow >= row || nextCol < 0 || nextCol >= col) {
                    continue;
                }

                if (!visited[nextRow][nextCol] && board[nextRow][nextCol] != 0) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}