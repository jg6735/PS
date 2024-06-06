import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final String START = "Started!";
    static final String WAIT = "Waiting!";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder result = new StringBuilder();
        Map<Integer, Set<String>> room = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> levels = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(in.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            levels.put(nickname, level);
            if (room.isEmpty()) {
                room.put(idx, new TreeSet<>());
                room.get(idx).add(nickname);
                list.add(level);
                continue;
            }

            boolean check = false;
            for (int j = 0; j < list.size(); j++) {
                if (room.get(j).size() < m && Math.abs(list.get(j) - level) <= 10) {
                    room.get(j).add(nickname);
                    check = true;
                    break;
                }
            }

            if (!check) {
                room.put(++idx, new TreeSet<>());
                room.get(idx).add(nickname);
                list.add(level);
            }
        }

        for (int i = 0; i < room.size(); i++) {
            if (room.get(i).size() == m) {
                result.append(START).append("\n");
            } else {
                result.append(WAIT).append("\n");
            }

            for (String nickname : room.get(i)) {
                result.append(levels.get(nickname)).append(" ").append(nickname).append("\n");
            }
        }

        System.out.print(result);
    }
}