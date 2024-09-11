import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(weight, value);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(Jewel::getWeight));
        Arrays.sort(bags);

        long result = getResult(bags, N, jewels);
        System.out.print(result);
    }

    private static long getResult(int[] bags, int N, Jewel[] jewels) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long result = 0;
        int index = 0;
        for (int bag : bags) {
            while (index < N && jewels[index].getWeight() <= bag) {
                pq.add(jewels[index].getValue());
                index++;
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        return result;
    }
}

class Jewel {
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}