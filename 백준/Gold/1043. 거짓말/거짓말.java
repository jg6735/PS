import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent, rank;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(in.readLine());
        int knownCount = Integer.parseInt(st.nextToken());
        int[] knownPeople = new int[knownCount];
        for (int i = 0; i < knownCount; i++) {
            knownPeople[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int[][] participants = new int[M][];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int participantCount = Integer.parseInt(st.nextToken());
            participants[i] = new int[participantCount];
            for (int j = 0; j < participantCount; j++) {
                participants[i][j] = Integer.parseInt(st.nextToken());
            }

            // 두 명 이상 참석한 파티는 병합
            if (participantCount >= 2) {
                int prev = participants[i][0];
                for (int j = 1; j < participantCount; j++) {
                    union(prev, participants[i][j]);
                    prev = participants[i][j];
                }
            }
        }

        // 진실을 아는 사람은 0번을 대표로 병합
        for (int i = 1; i < knownCount; i++) {
            union(knownPeople[0], knownPeople[i]);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean check = false;
            for (int participant : participants[i]) {
                // 진실을 아는 사람이 있는 경우
                // 진실을 아는 사람과 참가자가 같은 집합에 속하면 거짓말 불가능
                if (knownCount > 0 && find(knownPeople[0]) == find(participant)) {
                    check = true;
                    break;
                }
            }

            if (!check) {
                answer++;
            }
        }

        System.out.print(answer);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootY] > rank[rootX]) {
                parent[rootX] = rootY;
            } else {
                parent[rootX] = rootY;
                rank[rootX]++;
            }
        }
    }
}