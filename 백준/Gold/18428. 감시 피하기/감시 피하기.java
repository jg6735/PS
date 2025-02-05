import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N;
    static char[][] map;
    static boolean check;
    static List<Coordinate> teachers, students, empty;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        empty = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = st.nextToken().charAt(0);
                if (map[r][c] == 'S') {
                    students.add(new Coordinate(r, c));
                } else if (map[r][c] == 'T') {
                    teachers.add(new Coordinate(r, c));
                } else {
                    empty.add(new Coordinate(r, c));
                }
            }
        }

        setObstacle(0, 0);
        System.out.print(check ? "YES" : "NO");
    }

    static void setObstacle(int depth, int start) {
        if (depth == 3) {
            for (Coordinate teacher : teachers) {
                if (canWatch(teacher)) {
                    return;
                }
            }

            check = true;
            return;
        }

        for (int i = start; i < empty.size(); i++) {
            Coordinate cur = empty.get(i);
            if (map[cur.getR()][cur.getC()] == 'X') {
                map[cur.getR()][cur.getC()] = 'O';
                setObstacle(depth + 1, i + 1);
                map[cur.getR()][cur.getC()] = 'X';
            }
        }
    }

    static boolean canWatch(Coordinate teacher) {
        int curR = teacher.getR();
        int curC = teacher.getC();
        for (int d = 0; d < 4; d++) {
            int nextR = curR + dr[d];
            int nextC = curC + dc[d];
            while (nextR >= 0 && nextC >= 0 && nextR < N && nextC < N) {
                if (map[nextR][nextC] == 'S') {
                    return true;
                }

                if (map[nextR][nextC] == 'O') {
                    break;
                }

                nextR += dr[d];
                nextC += dc[d];
            }
        }

        return false;
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