import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static int N, M, K;
    private static int[][] map, foods;
    private static Deque<Tree> list;
    private static List<Tree> deadTrees;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        while (K-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }

    }

    private static void spring() {
        deadTrees = new LinkedList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Tree tree = list.poll();
            int r = tree.getR();
            int c = tree.getC();
            int age = tree.getAge();

            if (map[r][c] >= age) {
                map[r][c] -= age;
                tree.plusAge();
                list.add(tree);
            } else {
                deadTrees.add(tree);
            }
        }
    }

    private static void summer() {
        for (Tree tree : deadTrees) {
            int r = tree.getR();
            int c = tree.getC();
            int age = tree.getAge();

            map[r][c] += age / 2;
        }
    }

    private static void fall() {
        Queue<Tree> old = new LinkedList<>();
        for (Tree tree : list) {
            if (tree.getAge() % 5 == 0) {
                old.add(tree);
            }
        }

        while (!old.isEmpty()) {
            Tree cur = old.poll();
            int curR = cur.getR();
            int curC = cur.getC();

            for (int d = 0; d < 8; d++) {
                int nextR = curR + DR[d];
                int nextC = curC + DC[d];

                if (canVisit(nextR, nextC)) {
                    list.addFirst(new Tree(nextR, nextC, 1));
                }
            }
        }
    }

    private static void winter() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] += foods[r][c];
            }
        }
    }

    private static boolean canVisit(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        foods = new int[N][N];
        map = new int[N][N];
        list = new ArrayDeque<>();
        for (int r = 0; r < N; r++) {
            Arrays.fill(map[r], 5);
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                foods[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            list.add(new Tree(x, y, z));
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(list.size()));
        out.flush();
    }

    private static class Tree {
        private int r;
        private int c;
        private int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getAge() {
            return age;
        }

        public void plusAge() {
            this.age++;
        }
    }
}