package PS_Level0.k의개수;

public class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;

        StringBuilder builder = new StringBuilder();
        for (int tc = i; tc <= j; tc++) {
            if (String.valueOf(tc).contains(String.valueOf(k))) {
                builder.append(tc);
            }
        }

        for (int tc = 0; tc < builder.length(); tc++) {
            if (builder.toString().charAt(tc) - '0' == k) {
                answer++;
            }
        }

        return answer;
    }
}
