import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, answer;
    private static int[] arr;
    private static LinkedList<Integer> list;

    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < M; i++) {
            int idx = list.indexOf(arr[i]);

            int half;
            if (list.size() % 2 == 0) {
                half = list.size() / 2 - 1;
            } else {
                half = list.size() / 2;
            }

            if (idx <= half) {
                for (int j = 0; j < idx; j++) {
                    list.addLast(list.pollFirst());
                    answer++;
                }
            } else {
                for (int j = 0; j < list.size() - idx; j++) {
                    list.addFirst(list.pollLast());
                    answer++;
                }
            }


            list.pollFirst();
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        list = new LinkedList<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
    }

    private static void print() throws IOException {
        out.write(String.valueOf(answer));
        out.flush();
    }
}