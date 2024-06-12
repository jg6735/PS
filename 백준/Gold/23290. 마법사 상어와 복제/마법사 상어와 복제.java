import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static final int[] DR = {0, -1, -1, -1, 0, 1, 1, 1};
    static final int[] DC = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] SR = {-1, 0, 1, 0};
    static final int[] SC = {0, -1, 0, 1};

    static int M, S, eatCount, answer;
    static List<Fish> fishes;
    static Shark shark;
    static int[][] smells;
    static ArrayList<Fish>[][] map;
    static int[] sharkMovedListTemp;
    static int[] sharkMovedList;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        fishes = new ArrayList<>();
        smells = new int[4][4];
        map = new ArrayList[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                map[r][c] = new ArrayList<>();
            }
        }
        sharkMovedListTemp = new int[3];
        sharkMovedList = new int[3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            fishes.add(new Fish(r, c, d));
        }

        st = new StringTokenizer(in.readLine());
        shark = new Shark(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);

        while (S-- > 0) {
            // 1. 복제 마법 시전
            List<Fish> copiedList = duplicateFishes();

            // 2. 모든 물고기 한 칸 이동
            moveAllFishes();

            // 3 - 1. 상어 이동 경로 찾기
            eatCount = Integer.MIN_VALUE;
            findSharkRoute(0);
            // 3 - 2. 상어 이동
            moveShark();

            // 4. 2턴 전의 물고기 냄새 제거
            removeSmells();

            // 5. 물고기 복제
            copyFishes(copiedList);

            // 격자의 물고기 수 구하기
            getCount();
        }

        System.out.print(answer);
    }

    private static void getCount() {
        fishes.clear();
        int count = 0;
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                for (int i = 0; i < map[r][c].size(); i++) {
                    Fish fish = map[r][c].get(i);
                    fishes.add(fish);
                    count++;
                }

                map[r][c].clear();
            }
        }

        answer = count;
    }

    private static List<Fish> duplicateFishes() {
        List<Fish> copied = new ArrayList<>();
        for (Fish fish : fishes) {
            copied.add(new Fish(fish.getR(), fish.getC(), fish.getD()));
        }

        return copied;
    }

    private static void copyFishes(List<Fish> copiedList) {
        for (Fish fish : copiedList) {
            map[fish.getR()][fish.getC()].add(fish);
        }
    }

    private static void removeSmells() {
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (smells[r][c] > 0) {
                    smells[r][c]--;
                }
            }
        }
    }

    private static void findSharkRoute(int cnt) {
        if (cnt == 3) {
            int count = checkEatCount();
            if (count == -1) {
                return;
            }

            if (eatCount < count) {
                eatCount = count;
                System.arraycopy(sharkMovedListTemp, 0, sharkMovedList, 0, 3);
            }

            return;
        }

        for (int i = 0; i < 4; i++) {
            sharkMovedListTemp[cnt] = i + 1;
            findSharkRoute(cnt + 1);
        }
    }

    private static void moveShark() {
        int r = shark.getR();
        int c = shark.getC();
        for (int i = 0; i < 3; i++) {
            r += SR[sharkMovedList[i] - 1];
            c += SC[sharkMovedList[i] - 1];
            if (!map[r][c].isEmpty()) {
                smells[r][c] = 3;
                map[r][c].clear();
            }
        }

        shark.move(r, c, 0);
    }

    private static int checkEatCount() {
        boolean[][] visited = new boolean[4][4];
        int result = 0;
        int r = shark.getR();
        int c = shark.getC();
        for (int i = 0; i < 3; i++) {
            r += SR[sharkMovedListTemp[i] - 1];
            c += SC[sharkMovedListTemp[i] - 1];

            if (isOutside(r, c)) {
                return -1;
            }

            if (!visited[r][c]) {
                visited[r][c] = true;
                result += map[r][c].size();
            }
        }

        return result;
    }

    private static void moveAllFishes() {
        for (Fish fish : fishes) {
            int r = fish.getR();
            int c = fish.getC();
            int d = fish.getD();

            int cnt = 0;
            while (cnt++ <= 8) {
                int nextR = r + DR[d];
                int nextC = c + DC[d];
                if (isOutside(nextR, nextC) || isSharkLived(nextR, nextC) || isSmelled(nextR, nextC)) {
                    d--;
                    if (d < 0) {
                        d = 7;
                    }
                } else {
                    fish.move(nextR, nextC, d);
                    break;
                }
            }

            map[fish.getR()][fish.getC()].add(fish);
        }
    }

    private static boolean isOutside(int r, int c) {
        return r < 0 || c < 0 || r >= 4 || c >= 4;
    }

    private static boolean isSharkLived(int r, int c) {
        return r == shark.getR() && c == shark.getC();
    }

    private static boolean isSmelled(int r, int c) {
        return smells[r][c] > 0;
    }
}

class Fish {
    private int r;
    private int c;
    private int d;

    public Fish(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
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

    public void move(int nextR, int nextC, int d) {
        this.r = nextR;
        this.c = nextC;
        this.d = d;
    }
}

class Shark extends Fish {
    public Shark(int r, int c) {
        super(r, c, 0);
    }
}