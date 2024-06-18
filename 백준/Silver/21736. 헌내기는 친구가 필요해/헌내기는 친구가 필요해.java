import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int[] DX = {0, 1, 0, -1};
    static final int[] DY = {-1, 0, 1, 0};

    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Coordinate start = null;
        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'I') {
                    start = new Coordinate(j, i);
                }
            }
        }

        int result = bfs(start);
        System.out.print(result != 0 ? result : "TT");
    }

    static int bfs(Coordinate start) {
        Queue<Coordinate> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(start);

        Coordinate cur;
        int curX, curY, nextX, nextY;
        int count = 0;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            curX = cur.getX();
            curY = cur.getY();

            for (int d = 0; d < 4; d++) {
                nextX = curX + DX[d];
                nextY = curY + DY[d];

                if (nextX < 0 || nextX >= M || nextY < 0 || nextY >= N) {
                    continue;
                }

                if (visited[nextY][nextX]) {
                    continue;
                }

                if (map[nextY][nextX] == 'X') {
                    continue;
                }

                if (map[nextY][nextX] == 'O') {
                    visited[nextY][nextX] = true;
                    queue.add(new Coordinate(nextX, nextY));
                }

                if (map[nextY][nextX] == 'P') {
                    visited[nextY][nextX] = true;
                    queue.add(new Coordinate(nextX, nextY));
                    count++;
                }
            }
        }

        return count;
    }
}

class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}