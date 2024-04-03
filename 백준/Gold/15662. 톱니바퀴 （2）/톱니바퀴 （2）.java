import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int T, K, answer;
    private static Wheel[] wheels;
    private static int[][] infos;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int[] info : infos) {
            int number = info[0];
            int dir = info[1];
            Wheel cur = wheels[number];
            boolean[] isRotated = getRotateNumber(cur);
            rotateRight(cur, isRotated, dir);
            dir = info[1] * -1;
            rotateLeft(cur, isRotated, dir);
        }

        for (int i = 0; i < T; i++) {
            if (wheels[i].getStatus()[0] == 1) {
                answer++;
            }
        }
    }

    private static void rotateLeft(Wheel cur, boolean[] isRotated, int dir) {
        for (int n = cur.getNumber() - 1; n >= 0; n--) {
            if (isRotated[n]) {
                wheels[n].rotate(dir);
                dir *= -1;
            }
        }
    }

    private static void rotateRight(Wheel cur, boolean[] isRotated, int dir) {
        for (int n = cur.getNumber(); n < T; n++) {
            if (isRotated[n]) {
                wheels[n].rotate(dir);
                dir *= -1;
            }
        }
    }

    private static boolean[] getRotateNumber(Wheel cur) {
        boolean[] isRotated = new boolean[T];
        isRotated[cur.getNumber()] = true;

        for (int n = cur.getNumber() + 1; n < T; n++) {
            if (wheels[n].getStatus()[6] != wheels[n - 1].getStatus()[2]) {
                isRotated[n] = true;
            } else {
                break;
            }
        }

        for (int n = cur.getNumber() - 1; n >= 0; n--) {
            if (wheels[n].getStatus()[2] != wheels[n + 1].getStatus()[6]) {
                isRotated[n] = true;
            } else {
                break;
            }
        }

        return isRotated;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(in.readLine());
        wheels = new Wheel[T];
        for (int i = 0; i < T; i++) {
            wheels[i] = new Wheel(i, in.readLine());
        }
        K = Integer.parseInt(in.readLine());
        infos = new int[K][2];
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(in.readLine());
            infos[i][0] = Integer.parseInt(st.nextToken()) - 1;
            infos[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }
}

class Wheel {
    private final int number;
    private final int[] status;

    public Wheel(int number, String input) {
        this.number = number;
        this.status = new int[8];
        for (int i = 0; i < 8; i++) {
            this.status[i] = input.charAt(i) - '0';
        }
    }

    public int getNumber() {
        return number;
    }

    public int[] getStatus() {
        return status;
    }

    public void rotate(int dir) {
        if (dir == -1) {
            int temp = status[0];
            for (int i = 0; i < 7; i++) {
                status[i] = status[i + 1];
            }

            status[7] = temp;
        } else if (dir == 1) {
            int temp = status[7];
            for (int i = 7; i > 0; i--) {
                status[i] = status[i - 1];
            }

            status[0] = temp;
        }
    }
}