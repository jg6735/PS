import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] DR = {-3, -3, -2, 2, 3, 3, 2, -2};
    static final int[] DC = {-2, 2, 3, 3, 2, -2, -3, -3};
    static final int[][] rList = {{-1, -2}, {-1, -2}, {0, -1}, {0, 1}, {1, 2}, {1, 2}, {0, 1}, {0, -1}};
    static final int[][] cList = {{0, -1}, {0, 1}, {1, 2}, {1, 2}, {0, 1}, {0, -1}, {-1, -2}, {-1, -2}};

    static Unit s, k;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        s = new Unit(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
        st = new StringTokenizer(in.readLine());
        k = new Unit(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

        int result = bfs();
        System.out.print(result);
    }

    static int bfs() {
        Queue<Unit> queue = new LinkedList<>();
        queue.add(s);
        boolean[][] visited = new boolean[10][9];
        visited[s.getR()][s.getC()] = true;

        while (!queue.isEmpty()) {
            Unit cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int count = cur.getCount();
            if (curR == k.getR() && curC == k.getC()) {
                return count;
            }

            for (int d = 0; d < 8; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (nextR < 0 || nextR >= 10 || nextC < 0 || nextC >= 9) {
                    continue;
                }

                if (visited[nextR][nextC]) {
                    continue;
                }

                boolean check = false;
                for (int i = 0; i < 2; i++) {
                    if (curR + rList[d][i] == k.getR() && curC + cList[d][i] == k.getC()) {
                        check = true;
                        break;
                    }
                }

                if (!check) {
                    visited[nextR][nextC] = true;
                    queue.add(new Unit(nextR, nextC, count + 1));
                }
            }
        }

        return -1;
    }
}

class Unit {
    private int r;
    private int c;
    private int count;

    public Unit(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getCount() {
        return count;
    }
}