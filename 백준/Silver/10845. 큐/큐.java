import java.io.*;

public class Main {

    private static Queue queue;
    private static int N;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        while (N-- > 0) {
            String cmd = in.readLine();

            if (cmd.contains("push")) {
                queue.push(Integer.parseInt(cmd.substring(5)));
            } else if (cmd.equals("size")) {
                builder.append(queue.size()).append("\n");
            } else if (cmd.equals("pop")) {
                builder.append(queue.pop()).append("\n");
            } else if (cmd.equals("front")) {
                builder.append(queue.front()).append("\n");
            } else if (cmd.equals("back")) {
                builder.append(queue.back()).append("\n");
            } else if (cmd.equals("empty")) {
                builder.append(queue.isEmpty() ? "1" : "0").append("\n");
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        queue = new Queue();
        N = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }
}

class Queue {
    private static final int SIZE = 10_001;
    private final int[] numbers;
    private int front;
    private int rear;

    public Queue() {
        numbers = new int[SIZE];
        front = rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void push(int x) {
        numbers[rear++] = x;
    }

    public int size() {
        return rear - front;
    }

    public int pop() {
        if (isEmpty()) {
            return -1;
        }
        
        return numbers[front++];
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }

        return numbers[front];
    }

    public int back() {
        if (isEmpty()) {
            return -1;
        }

        return numbers[rear - 1];
    }
}