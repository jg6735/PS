package PS_Level2.타겟넘버;

// https://school.programmers.co.kr/learn/courses/30/lessons/43165
class Solution {
    private static int answer = 0;

    private static void dfs(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                answer++;
            }

            return;
        }

        dfs(depth + 1, sum + numbers[depth], numbers, target);
        dfs(depth + 1, sum - numbers[depth], numbers, target);
    }

    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
}