package PS_Level0.직사각형넓이구하기;

public class Solution {
    public int solution(int[][] dots) {
        int width = 0;
        int height = 0;
        for (int i = 1; i < dots.length; i++) {
            if (dots[i][0] == dots[0][0]) {
                height = Math.abs(dots[0][1] - dots[i][1]);
            }

            if (dots[i][1] == dots[0][1]) {
                width = Math.abs(dots[0][0] - dots[i][0]);
            }
        }

        return width * height;
    }
}
