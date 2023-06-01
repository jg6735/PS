package PS_Level1.수박수박수박수박수박수;

public class Solution {
    public String solution(int n) {
        return "수박".repeat(n % 2 == 0 ? n / 2 : n / 2 + 1).substring(0, n);
    }
}
