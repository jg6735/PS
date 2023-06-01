package PS_Level0.A로B만들기;

public class Solution {
    public int solution(String before, String after) {
        int[] be = new int['z' + 1];
        int[] af = new int['z' + 1];

        for (int i = 0; i < before.length(); i++) {
            be[before.charAt(i) - '0']++;
            af[after.charAt(i) - '0']++;
        }

        for (int i = 0; i < be.length; i++) {
            if (be[i] != af[i]) {
                return 0;
            }
        }

        return 1;
    }
}
