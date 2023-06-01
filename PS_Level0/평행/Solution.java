package PS_Level0.평행;

public class Solution {
    public int solution(int[][] dots) {
        return isParallel(dots);
    }

    private int isParallel(int[][] dots) {
        if (getSlope(dots[0], dots[1]) == getSlope(dots[2], dots[3])
                || getSlope(dots[0], dots[2]) == getSlope(dots[1], dots[3])
                || getSlope(dots[0], dots[3]) == getSlope(dots[1], dots[2])
        ) {
            return 1;
        }

        return 0;
    }

    private double getSlope(int[] dot1, int[] dot2) {
        return (double) (dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
}
