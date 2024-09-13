import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> positives = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> negatives = new PriorityQueue<>();
        Queue<Integer> zeros = new LinkedList<>();
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 1) {
                answer++;
            } else if (input < 0) {
                negatives.add(input);
            } else if (input > 1) {
                positives.add(input);
            } else {
                zeros.add(input);
            }
        }

        while (!positives.isEmpty()) {
            int prev = positives.poll();
            if (positives.isEmpty()) {
                answer += prev;
            } else {
                answer += prev * positives.poll();
            }
        }

        while (!negatives.isEmpty()) {
            int prev = negatives.poll();
            if (negatives.isEmpty()) {
                if (!zeros.isEmpty()) {
                    zeros.poll();
                } else {
                    answer += prev;
                }
            } else {
                answer += prev * negatives.poll();
            }
        }

        System.out.print(answer);
    }
}