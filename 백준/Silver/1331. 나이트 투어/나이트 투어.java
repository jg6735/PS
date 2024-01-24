import java.io.*;

public class Main {

    private static final int[] DR = {-2, -2, -1, 1, 2, 2, 1, -1};
    private static final int[] DC = {-1, 1, 2, 2, 1, -1, -2, -2};
    private static final String VALID = "Valid";
    private static final String INVALID = "Invalid";

    private static String answer;
    private static boolean[][] visited;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        String input = in.readLine();
        char prevRow = input.charAt(1);
        char prevCol = input.charAt(0);
        visited[prevRow - '0' - 1][prevCol] = true;
        for (int i = 0; i < 35; i++) {
            String cur = in.readLine();
            char curRow = cur.charAt(1);
            char curCol = cur.charAt(0);
            if (!canMove(curRow, curCol, prevRow, prevCol)) {
                answer = INVALID;
                return;
            }

            visited[curRow - '0' - 1][curCol] = true;
            prevRow = curRow;
            prevCol = curCol;
        }

        visited = new boolean[6]['F' + 2];
        if (!canMove(input.charAt(1), input.charAt(0), prevRow, prevCol)) {
            answer = INVALID;
            return;
        }

        answer = VALID;
    }

    private static boolean canMove(char curRow, char curCol, char prevRow, char prevCol) {
        for (int d = 0; d < 8; d++) {
            char row = (char) (prevRow + DR[d]);
            char col = (char) (prevCol + DC[d]);

            if (row == curRow && col == curCol) {
                return !visited[row - '0' - 1][col];
            }
        }

        return false;
    }

    private static void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        visited = new boolean[6]['F' + 1];
    }

    private static void print() throws IOException {
        out.write(answer);
        out.flush();
    }
}