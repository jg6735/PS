import java.io.*;
import java.util.*;

public class Main {

    private static int n, w, L, answer;
    private static List<Truck> list;
    private static Queue<Truck> queue;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        int curWeight = L;
        while (!queue.isEmpty() || !list.isEmpty()) {
            if (!queue.isEmpty() && curWeight >= queue.peek().getWeight()) {
                Truck cur = queue.poll();
                curWeight -= cur.getWeight();
                list.add(cur);
            }

            for (Truck truck : list) {
                truck.move();
            }

            Truck truck = list.get(0);
            if (truck.getLocation() == w) {
                curWeight += truck.getWeight();
                list.remove(truck);
            }

            answer++;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken()); // 트럭 수
        w = Integer.parseInt(st.nextToken()); // 다리 길이
        L = Integer.parseInt(st.nextToken()); // 최대 하중
        list = new ArrayList<>();
        queue = new LinkedList<>();

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            queue.add(new Truck(Integer.parseInt(st.nextToken()), 0));
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer + 1));
        out.flush();
    }

    private static class Truck {
        private final int weight;
        private int location;

        public Truck(int weight, int location) {
            this.weight = weight;
            this.location = location;
        }

        public int getWeight() {
            return weight;
        }

        public int getLocation() {
            return location;
        }

        public void move() {
            location++;
        }

        @Override
        public String toString() {
            return "Truck{" +
                    "weight=" + weight +
                    ", location=" + location +
                    '}';
        }
    }
}