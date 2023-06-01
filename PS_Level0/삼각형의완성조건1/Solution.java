package PS_Level0.삼각형의완성조건1;

import java.util.Arrays;

public class Solution {
    public int solution(int[] sides) {
        Arrays.sort(sides);
        return sides[0] < sides[1] + sides[2] ? 1 : 2;
    }
}
