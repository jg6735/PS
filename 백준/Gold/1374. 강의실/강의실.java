import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int no = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lecture(no, start, end));
        }

        list.sort(Comparator.comparingInt(Lecture::getStart));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = 0;
        for (Lecture lec : list) {
            while (!pq.isEmpty() && pq.peek() <= lec.getStart()) {
                pq.poll();
            }

            pq.add(lec.getEnd());
            min = Math.max(min, pq.size());
        }

        System.out.print(min);
    }
}

class Lecture {

    private int no;
    private int start;
    private int end;

    public Lecture(int no, int start, int end) {
        this.no = no;
        this.start = start;
        this.end = end;
    }

    public int getNo() {
        return no;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}