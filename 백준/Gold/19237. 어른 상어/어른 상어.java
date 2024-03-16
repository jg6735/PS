import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, 1, 0, 0};
    private static final int[] DC = {0, 0, -1, 1};

    private static int N, M, k, answer = -1;
    private static int[][][] smells;
    private static Shark[][] map;
    private static Shark[] list;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int cnt = 1;
        while (cnt < 1001) {
            spraySmell();
            moveShark();
            downSmell();

            boolean check = false;
            for (int i = 1; i < list.length; i++) {
                if (list[i] != null) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                answer = cnt;
                return;
            }

            cnt++;
        }
    }

    private static void spraySmell() {
        for (Shark shark : list) {
            if (shark != null) {
                smells[shark.getR()][shark.getC()][0] = shark.getNumber();
                smells[shark.getR()][shark.getC()][1] = k;
            }
        }
    }

    private static void moveShark() {
        for (Shark shark : list) {
            if (shark == null) {
                continue;
            }

            int curR = shark.getR();
            int curC = shark.getC();
            int curD = shark.getDir();
            boolean check = moveToNoSmell(shark, curD, curR, curC);
            if (!check) {
                moveToMySmell(shark, curD, curR, curC);
            }

            boolean isMoved = shark.move(map);
            if (!isMoved) {
                list[shark.getNumber() - 1] = null;
            }
        }
    }

    private static void moveToMySmell(Shark shark, int curD, int curR, int curC) {
        for (int d = 0; d < 4; d++) {
            int prior = shark.getPriorities()[curD][d];
            int nextR = curR + DR[prior];
            int nextC = curC + DC[prior];

            if (isInside(nextR, nextC) && smells[nextR][nextC][0] == shark.getNumber()) {
                shark.setDir(prior);
                break;
            }
        }
    }

    private static boolean moveToNoSmell(Shark shark, int curD, int curR, int curC) {
        for (int d = 0; d < 4; d++) {
            int prior = shark.getPriorities()[curD][d];
            int nextR = curR + DR[prior];
            int nextC = curC + DC[prior];

            if (isInside(nextR, nextC) && smells[nextR][nextC][1] == 0) {
                shark.setDir(prior);
                return true;
            }
        }

        return false;
    }

    private static void downSmell() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (smells[row][col][1] > 0) {
                    smells[row][col][1]--;

                    if (smells[row][col][1] == 0) {
                        smells[row][col][0] = 0;
                    }
                }
            }
        }
    }

    private static boolean isInside(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }


    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        smells = new int[N][N][2];
        map = new Shark[N][N];
        list = new Shark[M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                int number = Integer.parseInt(st.nextToken());
                if (number != 0) {
                    map[r][c] = new Shark(r, c, number, new int[4][4]);
                    list[number - 1] = map[r][c];
                }
            }
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            list[i].setDir(Integer.parseInt(st.nextToken()) - 1);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                st = new StringTokenizer(in.readLine());
                for (int l = 0; l < 4; l++) {
                    int prior = Integer.parseInt(st.nextToken()) - 1;
                    list[i].setPriorities(j, l, prior);
                }
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

    static class Shark {
        private int r;
        private int c;
        private final int number;
        private int dir;
        private final int[][] priorities;

        public Shark(int r, int c, int number, int[][] priorities) {
            this.r = r;
            this.c = c;
            this.number = number;
            this.priorities = priorities;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public int getNumber() {
            return number;
        }

        public int getDir() {
            return dir;
        }

        public void setDir(int dir) {
            this.dir = dir;
        }

        public int[][] getPriorities() {
            return priorities;
        }

        public void setPriorities(int curDir, int idx, int prior) {
            priorities[curDir][idx] = prior;
        }

        public boolean move(Shark[][] map) {
            int nextR = r + DR[dir];
            int nextC = c + DC[dir];

            if (map[nextR][nextC] != null) {
                if (map[nextR][nextC].getNumber() > number) {
                    map[nextR][nextC] = this;
                } else {
                    map[r][c] = null;
                    return false;
                }
            } else {
                map[nextR][nextC] = this;
                map[r][c] = null;
            }

            setR(nextR);
            setC(nextC);
            return true;
        }

    }
}