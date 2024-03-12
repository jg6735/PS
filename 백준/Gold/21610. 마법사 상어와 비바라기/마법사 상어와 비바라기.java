import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DR = {0, -1, -1, -1, 0, 1, 1, 1};
    private static final int[] DC = {-1, -1, 0, 1, 1, 1, 0, -1};

    private static int N, M;
    private static Queue<Coordinate> queue;
    private static int[][] map;
    private static int[] dirs, distances;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        Coordinate[] increasedList;
        boolean[][] visited;
        for (int i = 0; i < M; i++) {
            increasedList = new Coordinate[queue.size()]; // 물이 증가한 칸을 체크하기 위한 배열
            visited = new boolean[N][N]; // 구름이 사라진 위치를 체크하기 위한 배열
            moveClouds(i, increasedList, visited); // 구름 이동
            copyWater(increasedList); // 물 복사
            makeCloud(visited); // 구름 생성
        }
    }

    private static void moveClouds(int idx, Coordinate[] increasedList, boolean[][] visited) {
        int dir = dirs[idx];
        int distance = distances[idx];

        Coordinate coordinate;
        int curR, curC, nextR, nextC;
        int i = 0;
        while (!queue.isEmpty()) {
            coordinate = queue.poll();
            curR = coordinate.getR();
            curC = coordinate.getC();

            // 배열의 끝과 끝이 이어지도록 연결되므로 구름의 다음 위치를 나머지 연산을 통해 구한다.
            nextR = (curR + (DR[dir] * (distance % N)) + N) % N;
            nextC = (curC + (DC[dir] * (distance % N)) + N) % N;
            map[nextR][nextC]++; // 해당 위치 물의 양 증가
            visited[nextR][nextC] = true; // 구름이 사라진 위치 체크
            increasedList[i++] = new Coordinate(nextR, nextC); // 물이 증가한 칸 저장
        }
    }

    // 물이 증가한 칸을 저장한 리스트를 참조해 물을 복사하는 메서드
    private static void copyWater(Coordinate[] increasedList) {
        int curR, curC, nextR, nextC;
        for (Coordinate cur : increasedList) {
            curR = cur.getR();
            curC = cur.getC();

            // 대각선 방향은 1, 3, 5, 7 방향으로 설정했다.
            for (int d = 1; d <= 7; d += 2) {
                nextR = curR + DR[d];
                nextC = curC + DC[d];

                // 경계가 넘어가지 않는 칸에 한해서 물의 양이 증가한다.
                if (isInside(nextR, nextC) && map[nextR][nextC] != 0) {
                    map[curR][curC]++;
                }
            }
        }
    }

    // 구름을 생성하고, 바구니의 물의 양을 감소시키는 메서드
    private static void makeCloud(boolean[][] visited) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && map[r][c] >= 2) {
                    map[r][c] -= 2;
                    queue.add(new Coordinate(r, c));
                }
            }
        }
    }

    // 배열 범위 이내인지 체크하는 메서드
    private static boolean isInside(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dirs = new int[M];
        distances = new int[M];
        queue = new LinkedList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            dirs[i] = Integer.parseInt(st.nextToken()) - 1;
            distances[i] = Integer.parseInt(st.nextToken());
        }

        initCloud(); // 초기 구름 생성
    }

    // 맨 처음 저장되는 구름을 추가하는 메서드
    private static void initCloud() {
        queue.add(new Coordinate(N - 1, 0));
        queue.add(new Coordinate(N - 1, 1));
        queue.add(new Coordinate(N - 2, 0));
        queue.add(new Coordinate(N - 2, 1));
    }

    private static void print() throws IOException {
        int sum = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sum += map[r][c];
            }
        }

        out.write(Integer.toString(sum));
        out.flush();
    }
}

class Coordinate {
    private int r;
    private int c;

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