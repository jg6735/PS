import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static int T;

    private static BufferedReader in;
    private static BufferedWriter out;
    private static StringBuilder builder;

    public static void main(String[] args) throws IOException {
        init();
        solve();
        print();
    }

    private static void solve() throws IOException {
        int n, k, t, m;
        StringTokenizer st;
        while (T-- > 0) {
            st = new StringTokenizer(in.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(in.readLine());
                int team = Integer.parseInt(st.nextToken());
                int number = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (teams[team - 1] == null) {
                    teams[team - 1] = new Team(team, new int[k], 1, i, score);
                }

                teams[team - 1].setScores(number, score);
                teams[team - 1].countSubmit();
                teams[team - 1].checkLastSubmit(i);
            }

            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += teams[i].getScores()[j];
                }

                teams[i].setTotal(sum);
            }

            Arrays.sort(teams, (o1, o2) -> {
                if (o1.getTotal() == o2.getTotal()) {
                    if (o1.getSubmitCnt() == o2.getSubmitCnt()) {
                        return o1.getLastSubmit() - o2.getLastSubmit();
                    }

                    return o1.getSubmitCnt() - o2.getSubmitCnt();
                }

                return o2.getTotal() - o1.getTotal();
            });

            for (int i = 0; i < n; i++) {
                if (teams[i].getId() == t) {
                    builder.append(i + 1).append("\n");
                    break;
                }
            }
        }
    }

    private static void init() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new BufferedWriter(new OutputStreamWriter(System.out));
        builder = new StringBuilder();
        T = Integer.parseInt(in.readLine());
    }

    private static void print() throws IOException {
        out.write(builder.toString());
        out.flush();
    }

    private static class Team {
        private int id;
        private int[] scores;
        private int submitCnt;
        private int lastSubmit;
        private int total;

        public Team(int id, int[] scores, int submitCnt, int lastSubmit, int total) {
            this.id = id;
            this.scores = scores;
            this.submitCnt = submitCnt;
            this.lastSubmit = lastSubmit;
            this.total = total;
        }

        public int getId() {
            return id;
        }

        public int[] getScores() {
            return scores;
        }

        public int getSubmitCnt() {
            return submitCnt;
        }

        public int getLastSubmit() {
            return lastSubmit;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int sum) {
            this.total = sum;
        }

        public void setScores(int number, int score) {
            scores[number - 1] = Math.max(score, scores[number - 1]);
        }

        public void countSubmit() {
            this.submitCnt++;
        }

        public void checkLastSubmit(int cnt) {
            this.lastSubmit = cnt;
        }
    }
}