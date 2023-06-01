package PS_Level1.실패율;

import java.util.Arrays;

public class Solution {
    static class FailureRate {
        private int index;
        private double rate;

        public FailureRate(int index, double rate) {
            this.index = index + 1;
            this.rate = rate;
        }

        public int getIndex() {
            return index;
        }

        public double getRate() {
            return rate;
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] notClearedPlayers = new int[N + 1];
        int[] reachedPlayers = new int[N];
        FailureRate[] failureRates = new FailureRate[N];
        int numberOfPlayers = stages.length;
        int sum = 0;

        for (int stage : stages) {
            notClearedPlayers[stage - 1]++;
        }

        for (int i = 0; i < reachedPlayers.length - 1; i++) {
            reachedPlayers[i] = numberOfPlayers - sum;
            sum += notClearedPlayers[i];
        }

        for (int i = 0; i < failureRates.length; i++) {
            if (reachedPlayers[i] == 0) {
                failureRates[i] = new FailureRate(i, 0);
                continue;
            }

            failureRates[i] = new FailureRate(i, (double) notClearedPlayers[i] / reachedPlayers[i]);
        }

        Arrays.sort(failureRates, ((o1, o2) -> Double.compare(o2.getRate(), o1.getRate())));

        for (int i = 0; i < answer.length; i++) {
            answer[i] = failureRates[i].getIndex();
        }

        return answer;
    }

}