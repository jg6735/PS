import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final char[] COLORS = {'w', 'y', 'r', 'o', 'g', 'b'};
    private static final int U = 0, D = 1, F = 2, B = 3, L = 4, R = 5;

    private static int T;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        int n;
        StringTokenizer st;
        char[][][] cube;
        while (T-- > 0) {
            n = Integer.parseInt(in.readLine());
            st = new StringTokenizer(in.readLine());
            cube = initCube();

            for (int i = 0; i < n; i++) {
                String str = st.nextToken();
                rotate(cube, str.charAt(0), str.charAt(1) == '+');
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    builder.append(cube[0][i][j]);
                }
                builder.append("\n");
            }
        }
    }

    private static char[][][] initCube() {
        char[][][] cube = new char[6][3][3];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = COLORS[i];
                }
            }
        }

        return cube;
    }

    private static void rotate(char[][][] cube, char dir, boolean clockwise) {
        switch (dir) {
            case 'U':
                rotateOne(cube, U, clockwise);
                change(cube, U, clockwise);
                break;
            case 'D':
                rotateOne(cube, D, !clockwise);
                change(cube, D, clockwise);
                break;
            case 'F':
                rotateOne(cube, F, clockwise);
                change(cube, F, clockwise);
                break;
            case 'B':
                rotateOne(cube, B, clockwise);
                change(cube, B, clockwise);
                break;
            case 'L':
                rotateOne(cube, L, clockwise);
                change(cube, L, clockwise);
                break;
            case 'R':
                rotateOne(cube, R, clockwise);
                change(cube, R, clockwise);
                break;
        }
    }

    private static void rotateOne(char[][][] cube, int dir, boolean clockwise) {
        char[][] copied = copiedCube(cube, dir);
        if (clockwise) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cube[dir][i][j] = copied[2 - j][i];
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    cube[dir][i][j] = copied[j][2 - i];
                }
            }
        }
    }

    private static char[][] copiedCube(char[][][] original, int dir) {
        char[][] copied = new char[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(original[dir][i], 0, copied[i], 0, 3);
        }

        return copied;
    }

    private static void change(char[][][] cube, int dir, boolean clockwise) {
        if (dir == U) {
            if (clockwise) {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[2][0][i];
                    cube[2][0][i] = cube[5][0][i];
                    cube[5][0][i] = cube[3][0][i];
                    cube[3][0][i] = cube[4][0][i];
                    cube[4][0][i] = temp;
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[2][0][i];
                    cube[2][0][i] = cube[4][0][i];
                    cube[4][0][i] = cube[3][0][i];
                    cube[3][0][i] = cube[5][0][i];
                    cube[5][0][i] = temp;
                }
            }
        } else if (dir == D) {
            if (clockwise) {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[2][2][i];
                    cube[2][2][i] = cube[4][2][i];
                    cube[4][2][i] = cube[3][2][i];
                    cube[3][2][i] = cube[5][2][i];
                    cube[5][2][i] = temp;
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[2][2][i];
                    cube[2][2][i] = cube[5][2][i];
                    cube[5][2][i] = cube[3][2][i];
                    cube[3][2][i] = cube[4][2][i];
                    cube[4][2][i] = temp;
                }
            }
        } else if (dir == F) {
            if (clockwise) {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][2][i];
                    cube[0][2][i] = cube[4][2 - i][2];
                    cube[4][2 - i][2] = cube[1][2][2 - i];
                    cube[1][2][2 - i] = cube[5][i][0];
                    cube[5][i][0] = temp;
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][2][i];
                    cube[0][2][i] = cube[5][i][0];
                    cube[5][i][0] = cube[1][2][2 - i];
                    cube[1][2][2 - i] = cube[4][2 - i][2];
                    cube[4][2 - i][2] = temp;
                }
            }
        } else if (dir == B) {
            if (clockwise) {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][0][i];
                    cube[0][0][i] = cube[5][i][2];
                    cube[5][i][2] = cube[1][0][2 - i];
                    cube[1][0][2 - i] = cube[4][2 - i][0];
                    cube[4][2 - i][0] = temp;
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][0][i];
                    cube[0][0][i] = cube[4][2 - i][0];
                    cube[4][2 - i][0] = cube[1][0][2 - i];
                    cube[1][0][2 - i] = cube[5][i][2];
                    cube[5][i][2] = temp;
                }
            }
        } else if (dir == L) {
            if (clockwise) {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][i][0];
                    cube[0][i][0] = cube[3][2 - i][2];
                    cube[3][2 - i][2] = cube[1][2 - i][0];
                    cube[1][2 - i][0] = cube[2][i][0];
                    cube[2][i][0] = temp;
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][i][0];
                    cube[0][i][0] = cube[2][i][0];
                    cube[2][i][0] = cube[1][2 - i][0];
                    cube[1][2 - i][0] = cube[3][2 - i][2];
                    cube[3][2 - i][2] = temp;
                }
            }
        } else if (dir == R) {
            if (clockwise) {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][i][2];
                    cube[0][i][2] = cube[2][i][2];
                    cube[2][i][2] = cube[1][2 - i][2];
                    cube[1][2 - i][2] = cube[3][2 - i][0];
                    cube[3][2 - i][0] = temp;
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    char temp = cube[0][i][2];
                    cube[0][i][2] = cube[3][2 - i][0];
                    cube[3][2 - i][0] = cube[1][2 - i][2];
                    cube[1][2 - i][2] = cube[2][i][2];
                    cube[2][i][2] = temp;
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        T = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}