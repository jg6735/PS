import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] DC = {0, -1, -1, -1, 0, 1, 1, 1};

    private static int[][] fishes;
    private static Fish[] info;
    private static int answer;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        info[fishes[0][0]].isEaten(true);
        int d = info[fishes[0][0]].getD();
        int sum = info[fishes[0][0]].getNumber();
        fishes[0][0] = -1;
        dfs(0, 0, d, sum);
    }

    private static void dfs(int sharkR, int sharkC, int sharkD, int sum) {
        answer = Math.max(answer, sum);

        int[][] copiedMap = new int[4][4];
        Fish[] copiedInfo = new Fish[17];
        copyMap(fishes, copiedMap);
        copyInfo(info, copiedInfo);

        moveAllFishes();
        moveShark(sharkR, sharkC, sharkD, sum);

        copyMap(copiedMap, fishes);
        copyInfo(copiedInfo, info);
    }

    private static void copyMap(int[][] original, int[][] copied) {
        for (int i = 0; i < 4; i++) {
            System.arraycopy(original[i], 0, copied[i], 0, 4);
        }
    }

    private static void copyInfo(Fish[] original, Fish[] copied) {
        for (int i = 1; i <= 16; i++) {
            Fish fish = original[i];
            copied[i] = new Fish(fish.getR(), fish.getC(), fish.getD(), fish.getNumber(), fish.isDead());
        }
    }

    private static void moveShark(int sharkR, int sharkC, int sharkD, int sum) {
        for (int i = 1; i < 4; i++) {
            int nextR = sharkR + DR[sharkD] * i;
            int nextC = sharkC + DC[sharkD] * i;

            if (isAvailable(nextR, nextC) && fishes[nextR][nextC] != 0) {
                int eatenFishNumber = fishes[nextR][nextC];
                int nextD = info[eatenFishNumber].getD();
                fishes[sharkR][sharkC] = 0;
                fishes[nextR][nextC] = -1;
                info[eatenFishNumber].isEaten(true);

                dfs(nextR, nextC, nextD, sum + eatenFishNumber);

                info[eatenFishNumber].isEaten(false);
                fishes[sharkR][sharkC] = -1;
                fishes[nextR][nextC] = eatenFishNumber;
            }
        }
    }

    private static void moveAllFishes() {
        for (int fishNumber = 1; fishNumber <= 16; fishNumber++) {
            if (info[fishNumber].isDead()) {
                continue;
            }

            Fish curFish = info[fishNumber];
            int curR = curFish.getR();
            int curC = curFish.getC();
            int curD = curFish.getD();

            for (int d = 0; d < 8; d++) {
                curD %= 8;
                curFish.setDir(curD);
                int nextR = curR + DR[curD];
                int nextC = curC + DC[curD];
                if (isAvailable(nextR, nextC) && fishes[nextR][nextC] != -1) {
                    swapFish(nextR, nextC, curR, curC, fishNumber);
                    break;
                }

                curD++;
            }
        }
    }

    private static void swapFish(int nextR, int nextC, int curFishR, int curFishC, int fishNumber) {
        if (fishes[nextR][nextC] == 0) {
            info[fishes[curFishR][curFishC]].move(nextR, nextC);
            fishes[curFishR][curFishC] = 0;
        } else {
            int nextFish = info[fishes[nextR][nextC]].getNumber();
            info[nextFish].move(curFishR, curFishC);
            info[fishes[curFishR][curFishC]].move(nextR, nextC);
            fishes[curFishR][curFishC] = nextFish;
        }

        fishes[nextR][nextC] = fishNumber;
    }

    private static boolean isAvailable(int r, int c) {
        return r >= 0 && c >= 0 && r < 4 && c < 4;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        fishes = new int[4][4];
        info = new Fish[17];

        StringTokenizer st;
        for (int r = 0; r < 4; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < 4; c++) {
                int number = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken()) - 1;
                Fish fish = new Fish(r, c, dir, number, false);
                fishes[r][c] = number;
                info[number] = fish;
            }
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }

    private static class Fish {
        private int r;
        private int c;
        private int d;
        private int number;
        private boolean isDead;

        public Fish(int r, int c, int d, int number, boolean isDead) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.number = number;
            this.isDead = isDead;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getD() {
            return d;
        }

        public int getNumber() {
            return number;
        }

        public boolean isDead() {
            return isDead;
        }

        public void isEaten(boolean eaten) {
            this.isDead = eaten;
        }

        public void setDir(int d) {
            this.d = d;
        }

        public void move(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}