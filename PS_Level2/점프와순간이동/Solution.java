package PS_Level2.점프와순간이동;

class Solution {
    public int solution(int n) {
//        return Integer.bitCount(n);
        int answer = 0;

        while (n > 0) {
            if (n % 2 != 0) {
                answer++;
                n--;
            } else {
                n /= 2;
            }
        }

        return answer;
    }
}