package PS_Level1.하샤드수;

public class Solution {
    public boolean solution(int x) {
        int num = x;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        if (num % sum == 0) {
            return true;
        }

        return false;
    }
}
