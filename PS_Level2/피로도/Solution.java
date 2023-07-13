package PS_Level2.피로도;

// https://school.programmers.co.kr/learn/courses/30/lessons/87946
class Solution {
    private static int result = 0;

    private static class Dungeon {
        private final int minimum;
        private final int fatigue;

        public Dungeon(int minimum, int fatigue) {
            this.minimum = minimum;
            this.fatigue = fatigue;
        }

        public int getMinimum() {
            return minimum;
        }

        public int getFatigue() {
            return fatigue;
        }
    }

    private static void dfs(int k, Dungeon[] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i].getMinimum() <= k) {
                visited[i] = true;
                dfs(k - dungeons[i].getFatigue(), dungeons, visited, count + 1);
                visited[i] = false;
            }
        }

        result = Math.max(result, count);
    }

    public int solution(int k, int[][] dungeons) {
        Dungeon[] arr = new Dungeon[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            arr[i] = new Dungeon(dungeons[i][0], dungeons[i][1]);
        }

        dfs(k, arr, new boolean[arr.length], 0);
        return result;
    }
}