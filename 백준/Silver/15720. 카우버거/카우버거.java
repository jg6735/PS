import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int B, C, D, sum, discounted;
    private static int[] burgers, sides, drinks;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() {
        sort();

        int min = Math.min(B, Math.min(C, D));
        for (int i = 0; i < min; i++) {
            discounted -= (burgers[i] + sides[i] + drinks[i]);
        }

        discounted = (discounted / 10) * 9;

        for (int i = min; i < B; i++) {
            discounted -= burgers[i];
        }
        for (int i = min; i < C; i++) {
            discounted -= sides[i];
        }
        for (int i = min; i < D; i++) {
            discounted -= drinks[i];
        }

        builder.append(sum).append("\n").append(discounted);
    }

    private static void sort() {
        Arrays.sort(burgers);
        Arrays.sort(sides);
        Arrays.sort(drinks);
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();

        StringTokenizer st = new StringTokenizer(in.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        burgers = new int[B];
        sides = new int[C];
        drinks = new int[D];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < B; i++) {
            int price = Integer.parseInt(st.nextToken());
            burgers[i] = -price;
            sum += price;
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < C; i++) {
            int price = Integer.parseInt(st.nextToken());
            sides[i] = -price;
            sum += price;
        }
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < D; i++) {
            int price = Integer.parseInt(st.nextToken());
            drinks[i] = -price;
            sum += price;
        }
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}