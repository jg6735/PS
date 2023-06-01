package PS_Level1.최소직사각형;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class Solution {
    public int solution(int[][] sizes) {
        int width = 0;
        int height = 0;
        for (int[] size : sizes) {
            width = Math.max(Math.max(size[0], size[1]), width);
            height = Math.max(Math.min(size[0], size[1]), height);
        }

        return width * height;
    }
}
