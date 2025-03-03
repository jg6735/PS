import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int answer;
    static char[][] arr = new char[5][5];
    static List<int[]> selected = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String input = in.readLine();
            for (int j = 0; j < 5; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        combination(0, 0, new boolean[5][5]);
        System.out.print(answer);
    }

    static void combination(int depth, int start, boolean[][] visited) {
        if (depth == 7) {
            if (isConnected() && countS() >= 4) {
                answer++;
            }

            return;
        }

        for (int i = start; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            if (!visited[r][c]) {
                visited[r][c] = true;
                selected.add(new int[]{r, c});
                combination(depth + 1, i + 1, visited);
                selected.remove(selected.size() - 1);
                visited[r][c] = false;
            }
        }
    }

    static boolean isConnected() {
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        int[] start = selected.get(0);
        queue.add(start);
        visited[start[0]][start[1]] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nextR = cur[0] + dr[d];
                int nextC = cur[1] + dc[d];

                if (nextR >= 0 && nextC >= 0 && nextR < 5 && nextC < 5) {
                    for (int[] pos : selected) {
                        if (!visited[pos[0]][pos[1]] && pos[0] == nextR && pos[1] == nextC) {
                            visited[nextR][nextC] = true;
                            queue.add(new int[]{nextR, nextC});
                            count++;
                        }
                    }
                }
            }
        }

        return count == 7;
    }

    static int countS() {
        int count = 0;
        for (int[] pos : selected) {
            if (arr[pos[0]][pos[1]] == 'S') {
                count++;
            }
        }

        return count;
    }
}