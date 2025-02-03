import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Integer[] cranes = new Integer[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(in.readLine());
        Integer[] boxes = new Integer[M];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < M; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cranes, Comparator.reverseOrder());
        Arrays.sort(boxes, Comparator.reverseOrder());

        if (boxes[0] > cranes[0]) {
            System.out.print(-1);
            return;
        }

        int[] boxIndexes = new int[N];
        boolean[] check = new boolean[M];
        int moveCount = 0;
        int time = 0;

        while (moveCount < M) {
            for (int i = 0; i < N; i++) {
                while (boxIndexes[i] < M) {
                    if (!check[boxIndexes[i]] && cranes[i] >= boxes[boxIndexes[i]]) {
                        check[boxIndexes[i]] = true;
                        boxIndexes[i]++;
                        moveCount++;
                        break;
                    }

                    boxIndexes[i]++;
                }
            }

            time++;
        }

        System.out.print(time);
    }
}