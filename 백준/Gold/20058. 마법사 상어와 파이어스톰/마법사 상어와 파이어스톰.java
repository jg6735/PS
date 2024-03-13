import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, Q, size, max;
    private static int[][] map;
    private static int[] magics;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < Q; i++) {
            map = divideMap(i);
            map = meltIce();
        }

        getMaxIce();
    }

    private static int[][] divideMap(int idx) {
        int magic = magics[idx];
        int smallSize = (int) Math.pow(2, magic);
        int[][] temp = new int[size][size];
        for (int r = 0; r < size; r += smallSize) {
            for (int c = 0; c < size; c += smallSize) {
                rotateMap(r, c, smallSize, temp);
            }
        }

        return temp;
    }

    private static void rotateMap(int startR, int startC, int size, int[][] temp) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                temp[startR + r][startC + c] = map[startR + size - c - 1][r + startC];
            }
        }
    }

    private static int[][] meltIce() {
        int[][] temp = copyMap();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (map[r][c] == 0) {
                    continue;
                }

                int count = 0;
                for (int d = 0; d < 4; d++) {
                    int nextR = r + DR[d];
                    int nextC = c + DC[d];

                    if (isInside(nextR, nextC) && map[nextR][nextC] != 0) {
                        count++;
                    }
                }

                if (count < 3) {
                    temp[r][c]--;
                }
            }
        }

        return temp;
    }

    private static int[][] copyMap() {
        int[][] temp = new int[size][size];
        for (int r = 0; r < size; r++) {
            System.arraycopy(map[r], 0, temp[r], 0, size);
        }

        return temp;
    }

    private static void getMaxIce() {
        boolean[][] visited = new boolean[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (!visited[r][c] && map[r][c] != 0) {
                    int count = bfs(r, c, visited);
                    max = Math.max(max, count);
                }
            }
        }
    }

    private static int bfs(int r, int c, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c));
        visited[r][c] = true;

        Coordinate cur;
        int curR, curC, nextR, nextC, count = 1;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curR = cur.getR();
            curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                nextR = curR + DR[d];
                nextC = curC + DC[d];

                if (isInside(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] != 0) {
                    queue.add(new Coordinate(nextR, nextC));
                    visited[nextR][nextC] = true;
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isInside(int r, int c) {
        return r >= 0 && c >= 0 && r < size && c < size;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        size = (int) Math.pow(2, N);
        map = new int[size][size];
        magics = new int[Q];
        for (int r = 0; r < size; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < size; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < Q; i++) {
            magics[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        int sum = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                sum += map[r][c];
            }
        }

        builder.append(sum).append("\n").append(max);
        out.write(builder.toString());
        out.flush();
    }
}

class Coordinate {
    private final int r;
    private final int c;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }
}