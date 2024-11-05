import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> minHeap = new PriorityQueue<>();

        StringBuilder builder = new StringBuilder();
        while (N-- > 0) {
            int input = Integer.parseInt(in.readLine());
            if (maxHeap.isEmpty() || input <= maxHeap.peek()) {
                maxHeap.add(input);
            } else {
                minHeap.add(input);
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            
            builder.append(maxHeap.peek()).append("\n");
        }

        System.out.print(builder);
    }

}