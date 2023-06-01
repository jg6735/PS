package PS_Level0.삼각형의완성조건2;

public class Solution {
    public int solution(int[] sides) {
        int min = Math.min(sides[0], sides[1]);
        return  min + min - 1;
    }
}
