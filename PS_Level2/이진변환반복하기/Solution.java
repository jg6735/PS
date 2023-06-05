package PS_Level2.이진변환반복하기;

// https://school.programmers.co.kr/learn/courses/30/lessons/70129
class Solution {
    public int[] solution(String s) {
        int removedZero = 0;
        int conversion = 0;

        while (!s.equals("1")) {
            int zeros = getZero(s);
            removedZero += zeros;
            s = Integer.toBinaryString(s.length() - zeros);
            conversion++;
        }

        return new int[]{conversion, removedZero};
    }

    private static int getZero(String s) {
        int zeros = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            }
        }

        return zeros;
    }
}