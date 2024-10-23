import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, D, answer;
    private static Archer[] archers;
    private static int[][] map;
    private static int[][] copiedMap;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        combination(0, 0, new boolean[M]);
    }

    private static void combination(int start, int depth, boolean[] line) {
        if (depth == 3) {
            setMap();
            setArcher(line);
            shoot();
            return;
        }

        for (int i = start; i < M; i++) {
            if (line[i]) {
                continue;
            }

            line[i] = true;
            combination(i + 1, depth + 1, line);
            line[i] = false;
        }
    }

    private static void setMap() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = copiedMap[r][c];
            }
        }
    }

    private static void setArcher(boolean[] line) {
        for (int i = 0; i < M; i++) {
            if (line[i]) {
                archers[i] = new Archer(i);
            } else {
                archers[i] = null;
            }
        }
    }

    private static void shoot() {
        int result = 0;
        for (int t = 0; t < N; t++) {
            List<int[]> targets = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                if (archers[i] == null) continue;
                int[] target = findEnemy(archers[i].getCol());
                if (target != null) {
                    targets.add(target);
                }
            }

            boolean[][] attacked = new boolean[N][M];
            for (int[] target : targets) {
                if (!attacked[target[0]][target[1]]) {
                    attacked[target[0]][target[1]] = true;
                    map[target[0]][target[1]] = 0;
                    result++;
                }
            }

            moveEnemies();
        }

        answer = Math.max(answer, result);
    }

    private static int[] findEnemy(int archerCol) {
        int minDist = Integer.MAX_VALUE;
        int minRow = -1;
        int minCol = -1;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 1) {
                    int dist = getDistance(r, c, archerCol);
                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && c < minCol)) {
                            minDist = dist;
                            minRow = r;
                            minCol = c;
                        }
                    }
                }
            }
        }

        return minRow == -1 ? null : new int[]{minRow, minCol};
    }

    private static void moveEnemies() {
        for (int r = N - 1; r > 0; r--) {
            for (int c = 0; c < M; c++) {
                map[r][c] = map[r - 1][c];
            }
        }

        for (int c = 0; c < M; c++) {
            map[0][c] = 0;
        }
    }

    private static int getDistance(int enemyRow, int enemyCol, int archerCol) {
        return Math.abs(N - enemyRow) + Math.abs(archerCol - enemyCol);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copiedMap = new int[N][M];
        archers = new Archer[M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                copiedMap[r][c] = map[r][c];
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}

class Archer {
    private int col;

    public Archer(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }
}