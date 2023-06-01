package PS_Level1.이천십육년;

// https://school.programmers.co.kr/learn/courses/30/lessons/12901
public class Solution {
    private static final String[] weeks = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
    private static final int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String solution(int a, int b) {
        int day = b;
        for (int i = 0; i < a - 1; i++) {
            day += days[i];
        }

        return weeks[day % 7];
    }
}
