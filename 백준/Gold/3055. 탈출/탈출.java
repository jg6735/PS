import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final String IMPOSSIBLE = "KAKTUS";
    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int R, C, answer;
    private static char[][] map;
    private static int[][] timeMap;
    private static List<Coordinate> waterList;
    private static boolean[][] visited;
    private static Coordinate character, goal;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        timeMap = new int[R][C];
        waterList = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            String input = in.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = input.charAt(c);
                if (map[r][c] == 'S') {
                    character = new Coordinate(r, c, 0);
                } else if (map[r][c] == 'D') {
                    goal = new Coordinate(r, c, 0);
                    timeMap[r][c] = Integer.MAX_VALUE;
                } else if (map[r][c] == '*') {
                    waterList.add(new Coordinate(r, c, 0));
                } else {
                    timeMap[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        spreadWater();
        search();
        System.out.print(answer == 0 ? IMPOSSIBLE : answer);
    }

    private static void spreadWater() {
        Queue<Coordinate> queue = new LinkedList<>();
        visited = new boolean[R][C];
        for (Coordinate water : waterList) {
            queue.add(water);
            visited[water.getR()][water.getC()] = true;
        }

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];
                if (!isInside(nextR, nextC)) {
                    continue;
                }

                if (!visited[nextR][nextC] && map[nextR][nextC] != 'D' && map[nextR][nextC] != 'X') {
                    queue.add(new Coordinate(nextR, nextC, 0));
                    visited[nextR][nextC] = true;
                    timeMap[nextR][nextC] = timeMap[curR][curC] + 1;
                }
            }
        }
    }

    private static void search() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(character);
        visited = new boolean[R][C];
        visited[character.getR()][character.getC()] = true;
        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curR = cur.getR();
            int curC = cur.getC();
            int curTime = cur.getTime();
            if (curR == goal.getR() && curC == goal.getC()) {
                answer = curTime;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];
                if (!isInside(nextR, nextC)) {
                    continue;
                }

                if (visited[nextR][nextC]) {
                    continue;
                }

                if (curTime + 1 < timeMap[nextR][nextC] && map[nextR][nextC] != '*' && map[nextR][nextC] != 'X') {
                    visited[nextR][nextC] = true;
                    queue.add(new Coordinate(nextR, nextC, curTime + 1));
                }
            }
        }
    }

    private static boolean isInside(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}

class Coordinate {

    private int r;
    private int c;
    private int time;

    public Coordinate(int r, int c, int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getTime() {
        return time;
    }
}