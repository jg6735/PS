import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    private static final int[] DC = {0, 1, 0, -1}; // 상, 우, 하, 좌

    private static int N, M, answer;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();     // 초기 입력
        solve();    // 풀이
        print();    // 출력
    }

    private static void solve() {
        while (true) {
            // 블록 그룹이 저장된 큐 반환 받아서
            Queue<Coordinate> queue = findBiggestBlock();
            // 비어 있으면 오토 플레이 중지
            if (queue.isEmpty()) {
                break;
            }

            // 크기가 가장 큰 블록 그룹을 제거하고 점수 추가
            answer += removeBlock(queue.poll());
            // 중력 작용
            gravity();
            // 격자 반시계 방향으로 회전
            map = rotate();
            // 중력 작용
            gravity();
        }
    }

    // 격자를 반시계 방향으로 회전하는 메서드
    private static int[][] rotate() {
        // 임시 배열을 생성해 저장 후 반환
        int[][] temp = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                temp[r][c] = map[c][N - r - 1];
            }
        }

        return temp;
    }

    // 중력을 작용하는 메서드
    private static void gravity() {
        for (int c = 0; c < N; c++) {
            for (int r = N - 1; r >= 1; r--) {
                // 빈 공간인 경우 중력 작용
                if (map[r][c] == -2) {
                    r = dropAndGetNextRow(r, c);
                }
            }
        }
    }

    // 블록을 떨어뜨리고, 다음 행을 구하는 메서드
    private static int dropAndGetNextRow(int r, int c) {
        for (int nextR = r - 1; nextR >= 0; nextR--) {
            // 다음 행이 -1로 막혀있다면 다음 행을 기준으로 하도록 반환
            if (map[nextR][c] == -1) {
                r = nextR;
                break;
                // 다음 행이 무지개 or 일반 블록이라면 떨어뜨리고 빈 공간으로 변환
            } else if (map[nextR][c] >= 0) {
                map[r][c] = map[nextR][c];
                map[nextR][c] = -2;
                r--; // 떨어뜨린 곳은 패스하도록 행 값 감소
            }
        }

        return r;
    }

    // 블록을 삭제시키고 total^2 만큼의 점수 획득
    private static int removeBlock(Coordinate cur) {
        int total = bfs(cur.getR(), cur.getC(), new boolean[N][N], true)[1];
        return (int) Math.pow(total, 2);
    }

    // 가장 큰 블록을 구하는 메서드
    private static Queue<Coordinate> findBiggestBlock() {
        // 우선순위큐를 이용해 블록의 개수, 무지개의 개수, 행, 열로 비교
        Queue<Coordinate> queue = new PriorityQueue<>((o1, o2) -> {
            if (o1.getTotal() == o2.getTotal()) {
                if (o1.getRainbowCount() == o2.getRainbowCount()) {
                    if (o1.getR() == o2.getR()) {
                        return o2.getC() - o1.getC();
                    }

                    return o2.getR() - o1.getR();
                }

                return o2.getRainbowCount() - o1.getRainbowCount();
            }

            return o2.getTotal() - o1.getTotal();
        });

        boolean[][] visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && map[r][c] > 0) {
                    // result[0] = 무지개 블록 개수, result[1] = 전체 블록 개수
                    int[] result = bfs(r, c, visited, false);
                    // 전체 블록 개수가 2개 이상인 경우만 블록 그룹의 기준 충족
                    if (result[1] >= 2) {
                        queue.add(new Coordinate(r, c, result[0], result[1]));
                    }
                }
            }
        }

        return queue;
    }

    private static int[] bfs(int r, int c, boolean[][] visited, boolean check) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(r, c));
        visited[r][c] = true;
        int color = map[r][c];

        Coordinate cur;
        int curR, curC, nextR, nextC, rainbow = 0, total = 1;
        List<Coordinate> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curR = cur.getR();
            curC = cur.getC();

            // 블록을 삭제시키는 경우 -2(빈 칸)으로 저장
            if (check) {
                map[curR][curC] = -2;
            }

            // 무지개 블록인 경우 개수 카운트
            if (map[curR][curC] == 0) {
                // 무지개 블록의 좌표를 리스트에 저장한다.
                list.add(new Coordinate(curR, curC));
                rainbow++;
            }

            for (int d = 0; d < 4; d++) {
                nextR = curR + DR[d];
                nextC = curC + DC[d];

                // 배열 범위 바깥인 경우 PASS
                if (!isInside(nextR, nextC)) {
                    continue;
                }

                // 이미 방문한 경우 PASS
                if (visited[nextR][nextC]) {
                    continue;
                }

                // 무지개 블록이거나 || 시작 블록의 색과 같은 경우 계속 탐색
                if (map[nextR][nextC] == 0 || map[nextR][nextC] == color) {
                    queue.add(new Coordinate(nextR, nextC));
                    visited[nextR][nextC] = true;
                    total++;
                }
            }
        }

        // 무지개 블록은 블록 그룹을 구성할 때 재사용될 수 있으므로 방문 체크를 해제한다.
        for (Coordinate rb : list) {
            visited[rb.getR()][rb.getC()] = false;
        }

        return new int[]{rainbow, total};
    }

    // 격자 크기 이내인지 체크하는 메서드
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
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}

class Coordinate {
    private final int r;
    private final int c;
    private int rainbowCount;
    private int total;

    public Coordinate(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public Coordinate(int r, int c, int rainbowCount, int total) {
        this.r = r;
        this.c = c;
        this.rainbowCount = rainbowCount;
        this.total = total;
    }

    public int getR() {
        return r;
    }

    public int getC() {
        return c;
    }

    public int getRainbowCount() {
        return rainbowCount;
    }

    public int getTotal() {
        return total;
    }
}