import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader in;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() throws IOException {
        int tc = 0;
        while (true) {
            int n = Integer.parseInt(in.readLine());
            // 입력이 0이면 종료
            if (n == 0) {
                return;
            }

            // 학생 이름 리스트에 저장
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(in.readLine());
            }

            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < n * 2 - 1; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                int number = Integer.parseInt(st.nextToken());

                if (numbers.contains(number)) {
                    numbers.remove((Integer) number);
                } else {
                    numbers.add(number);
                }
            }

            System.out.println(++tc + " " + list.get(numbers.get(0) - 1));
        }
    }

    private static void init() {
        in = new BufferedReader(new InputStreamReader(System.in));
    }
}