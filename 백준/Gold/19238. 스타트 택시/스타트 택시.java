import java.io.*;
import java.util.*;

public class Main {

    private static final int[] DR = {-1, 0, 1, 0};
    private static final int[] DC = {0, 1, 0, -1};

    private static int N, M, K, answer = -1;
    private static Taxi taxi;
    private static List<Customer> list;
    private static int[][] map;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < M; i++) {
            Customer customer = taxi.findShortestCustomer(list, map, taxi);
            if (customer == null) {
                return;
            }

            if (taxi.moveToDestination(customer)) {
                list.remove(customer);
            } else {
                return;
            }
        }

        answer = taxi.getFuel();
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(in.readLine());
        int taxiR = Integer.parseInt(st.nextToken()) - 1;
        int taxiC = Integer.parseInt(st.nextToken()) - 1;
        taxi = new Taxi(new Coordinate(taxiR, taxiC), K, 0);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int startR = Integer.parseInt(st.nextToken()) - 1;
            int startC = Integer.parseInt(st.nextToken()) - 1;
            int goalR = Integer.parseInt(st.nextToken()) - 1;
            int goalC = Integer.parseInt(st.nextToken()) - 1;
            list.add(new Customer(new Coordinate(startR, startC), new Coordinate(goalR, goalC)));
        }
    }

    private static void print() throws IOException {
        out.write(Integer.toString(answer));
        out.flush();
    }

    static class Customer {
        private final Coordinate start;
        private final Coordinate goal;
        private int distance;

        public Customer(Coordinate start, Coordinate goal) {
            this.start = start;
            this.goal = goal;
        }

        public Coordinate getStart() {
            return start;
        }

        public Coordinate getGoal() {
            return goal;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }
    }

    static class Taxi {
        private Coordinate coordinate;
        private int fuel;
        private int count;

        public Taxi(Coordinate coordinate, int fuel, int count) {
            this.coordinate = coordinate;
            this.fuel = fuel;
            this.count = count;
        }

        private static void arrive(Coordinate coordinate, int fuel) {
            taxi.setFuel(fuel);
            taxi.setCoordinate(coordinate);
            taxi.setCount(0);
        }

        public Coordinate getCoordinate() {
            return coordinate;
        }

        public void setCoordinate(Coordinate coordinate) {
            this.coordinate = coordinate;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public boolean isInside(int nextR, int nextC) {
            return nextR >= 0 && nextC >= 0 && nextR < N && nextC < N;
        }

        public Customer findShortestCustomer(List<Customer> list, int[][] map, Taxi start) {
            Queue<Taxi> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            visited[coordinate.getR()][coordinate.getC()] = true;
            queue.add(start);

            Queue<Customer> pq = new PriorityQueue<>((o1, o2) -> {
                if (o1.getDistance() == o2.getDistance()) {
                    if (o1.getStart().getR() == o2.getStart().getR()) {
                        return o1.getStart().getC() - o2.getStart().getC();
                    }

                    return o1.getStart().getR() - o2.getStart().getR();
                }

                return o1.getDistance() - o2.getDistance();
            });

            int curR, curC, nextR, nextC, curFuel, curCount;
            while (!queue.isEmpty()) {
                Taxi cur = queue.poll();
                curR = cur.getCoordinate().getR();
                curC = cur.getCoordinate().getC();
                curFuel = cur.getFuel();
                curCount = cur.getCount();

                for (Customer customer : list) {
                    int startR = customer.getStart().getR();
                    int startC = customer.getStart().getC();

                    if (curR == startR && curC == startC) {
                        customer.setDistance(curCount);
                        pq.add(customer);
                    }
                }

                for (int d = 0; d < 4; d++) {
                    nextR = curR + DR[d];
                    nextC = curC + DC[d];

                    if (isInside(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] != 1) {
                        queue.add(new Taxi(new Coordinate(nextR, nextC), curFuel - 1, curCount + 1));
                        visited[nextR][nextC] = true;
                    }
                }
            }

            if (pq.isEmpty()) {
                return null;
            }

            Customer customer = pq.poll();
            arrive(customer.getStart(), fuel - customer.getDistance());
            return customer;
        }

        public boolean moveToDestination(Customer customer) {
            Queue<Taxi> queue = new LinkedList<>();
            boolean[][] visited = new boolean[N][N];
            visited[customer.getStart().getR()][customer.getStart().getC()] = true;
            queue.add(taxi);

            int curR, curC, nextR, nextC, curFuel, curCount;
            while (!queue.isEmpty()) {
                Taxi cur = queue.poll();
                curR = cur.getCoordinate().getR();
                curC = cur.getCoordinate().getC();
                curFuel = cur.getFuel();
                curCount = cur.getCount();

                if (curR == customer.getGoal().getR() && curC == customer.getGoal().getC()) {
                    if (curFuel >= 0) {
                        arrive(customer.getGoal(), curCount * 2 + curFuel);
                        return true;
                    }

                    return false;
                }

                for (int d = 0; d < 4; d++) {
                    nextR = curR + DR[d];
                    nextC = curC + DC[d];

                    if (isInside(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 0) {
                        queue.add(new Taxi(new Coordinate(nextR, nextC), curFuel - 1, curCount + 1));
                        visited[nextR][nextC] = true;
                    }
                }
            }

            return false;
        }
    }

    static class Coordinate {
        private int r;
        private int c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }
}