import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static Egg[] eggs;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }

        dfs(0);
        System.out.print(max);
    }

    static void dfs(int idx) {
        if (idx == N) {
            int count = 0;
            for (Egg egg : eggs) {
                if (egg.getDurability() <= 0) {
                    count++;
                }
            }

            max = Math.max(max, count);
            return;
        }

        if (eggs[idx].getDurability() <= 0) {
            dfs(idx + 1);
            return;
        }

        boolean hit = false;
        for (int i = 0; i < N; i++) {
            if (i == idx || eggs[i].getDurability() <= 0) {
                continue;
            }

            eggs[idx].hit(eggs[i]);
            hit = true;
            dfs(idx + 1);
            eggs[idx].reset(eggs[i]);
        }

        if (!hit) {
            dfs(idx + 1);
        }
    }
}

class Egg {

    private int durability;
    private final int weight;

    public Egg(int durability, int weight) {
        this.durability = durability;
        this.weight = weight;
    }

    public int getDurability() {
        return durability;
    }

    public int getWeight() {
        return weight;
    }

    public void hit(Egg egg) {
        this.durability -= egg.getWeight();
        egg.durability -= this.weight;
    }

    public void reset(Egg egg) {
        this.durability += egg.getWeight();
        egg.durability += this.getWeight();
    }
}