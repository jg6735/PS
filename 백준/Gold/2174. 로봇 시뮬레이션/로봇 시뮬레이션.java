import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final int[] DX = {0, 1, 0, -1};
    private static final int[] DY = {1, 0, -1, 0};

    private static int A, B, N, M;
    private static Robot[] robots;
    private static Robot[][] map;
    private static String[][] commands;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (String[] command : commands) {
            int number = Integer.parseInt(command[0]);
            char cmd = command[1].charAt(0);
            int count = Integer.parseInt(command[2]);
            Robot cur = robots[number - 1];

            while (count-- > 0) {
                if (cmd == 'L') {
                    cur.rotate((cur.getDir() + 3) % 4);
                } else if (cmd == 'R') {
                    cur.rotate((cur.getDir() + 1) % 4);
                } else {
                    if (!move(cur)) {
                        return;
                    }
                }
            }
        }
    }

    private static boolean move(Robot robot) {
        int nextX = robot.getX() + DX[robot.getDir()];
        int nextY = robot.getY() - DY[robot.getDir()];
        if (!canMove(nextX, nextY)) {
            builder.append("Robot ").append(robot.getNumber()).append(" crashes into the wall");
            return false;
        }

        if (map[nextY][nextX] != null) {
            builder.append("Robot ").append(robot.getNumber()).append(" crashes into robot ").append(map[nextY][nextX].getNumber());
            return false;
        }

        map[robot.getY()][robot.getX()] = null;
        robot.move(nextX, nextY);
        map[nextY][nextX] = robot;
        return true;
    }

    private static boolean canMove(int x, int y) {
        return x >= 0 && y >= 0 && x < A && y < B;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new Robot[B][A];
        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        robots = new Robot[N];
        commands = new String[M][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            robots[i] = new Robot(x - 1, B - y, i + 1, dir);
            map[B - y][x - 1] = robots[i];
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < 3; j++) {
                commands[i][j] = st.nextToken();
            }
        }
    }

    private static void print() throws IOException {
        out.write(builder.length() == 0 ? "OK" : builder.toString());
        out.flush();
    }
}

class Robot {
    private int x;
    private int y;
    private final int number;
    private int dir;

    public Robot(int x, int y, int number, char dir) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.dir = initDir(dir);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    public int getDir() {
        return dir;
    }

    public int initDir(char dir) {
        if (dir == 'N') {
            return 0;
        } else if (dir == 'E') {
            return 1;
        } else if (dir == 'S') {
            return 2;
        } else {
            return 3;
        }
    }

    public void rotate(int dir) {
        this.dir = dir;
    }

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}