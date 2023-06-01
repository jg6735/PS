package PS_Level0.삼육구게임;

public class Solution {
    public int solution(int order) {
        int answer = 0;

        String number = String.valueOf(order);
        for (int i = 0; i < number.length(); i++) {
            int n = number.charAt(i) - '0';
            if (n % 3 == 0 && n != 0) {
                answer++;
            }
        }

        return answer;
    }
}
