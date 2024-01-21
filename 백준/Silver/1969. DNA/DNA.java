import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, distance;
    private static String[] dna;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        for (int i = 0; i < M; i++) {
            int[] count = new int[4];
            for (int j = 0; j < N; j++) {
                char c = dna[j].charAt(i);
                getCount(count, c);
            }

            int idx = 0;
            int max = 0;
            for (int j = 0; j < 4; j++) {
                if (count[j] > max || (count[j] == max && j < idx)) {
                    max = count[j];
                    idx = j;
                }
            }

            getDna(idx);
            distance += N - max;
        }

        builder.append("\n").append(distance);
    }

    private static void getDna(int idx) {
        switch (idx) {
            case 0:
                builder.append('A');
                break;
            case 1:
                builder.append('C');
                break;
            case 2:
                builder.append('G');
                break;
            case 3:
                builder.append('T');
                break;
        }
    }

    private static void getCount(int[] count, char c) {
        switch (c) {
            case 'A':
                count[0]++;
                break;
            case 'C':
                count[1]++;
                break;
            case 'G':
                count[2]++;
                break;
            case 'T':
                count[3]++;
                break;
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dna = new String[N];
        for (int i = 0; i < N; i++) {
            dna[i] = in.readLine();
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}