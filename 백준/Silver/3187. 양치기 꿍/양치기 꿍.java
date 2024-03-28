import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int R, C, v, k;
    private static char[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        boolean[][] visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != '#' && !visited[r][c]) {
                    searchMap(r, c, visited);
                }
            }
        }
    }

    private static void searchMap(int r, int c, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;

        int wolf = isWolfOrSheep(r, c, 'v');
        int sheep = isWolfOrSheep(r, c, 'k');
        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int curR = coordinate[0];
            int curC = coordinate[1];

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (!canVisit(nextR, nextC)) {
                    continue;
                }

                if (!visited[nextR][nextC] && map[nextR][nextC] != '#') {
                    if (map[nextR][nextC] == 'v') {
                        wolf++;
                    } else if (map[nextR][nextC] == 'k') {
                        sheep++;
                    }

                    queue.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }

        if (wolf >= sheep) {
            k -= sheep;
        } else {
            v -= wolf;
        }
    }

    private static int isWolfOrSheep(int r, int c, char vk) {
        return map[r][c] == vk ? 1 : 0;
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < R && c < C;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String input = in.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == 'v') {
                    v++;
                } else if (map[r][c] == 'k') {
                    k++;
                }
            }
        }
    }

    private static void print() throws IOException {
        builder.append(k).append(" ").append(v);
        out.write(builder.toString());
        out.flush();
    }
}