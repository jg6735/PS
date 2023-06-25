package PS_Level3.정수삼각형;

import java.util.Arrays;

class Solution {
    private final int[][] memo = new int[501][501];

    private int max(int x, int y, int[][] triangle) {
        if (y == triangle.length) {
            return 0;
        }

        if (memo[x][y] != -1) {
            return memo[x][y];
        }

        memo[x][y] = triangle[y][x] + Math.max(max(x, y + 1, triangle), max(x + 1, y + 1, triangle));
        return memo[x][y];
    }

    public int solution(int[][] triangle) {
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return max(0, 0, triangle);
    }
}
