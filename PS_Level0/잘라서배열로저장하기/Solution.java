package PS_Level0.잘라서배열로저장하기;

public class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[my_str.length() % n > 0 ? my_str.length() / n + 1 : my_str.length() / n];

        int length = my_str.length();
        for (int i = 0; i < answer.length; i++) {
            int endIndex = (i + 1) * n;
            if (endIndex >= length) {
                endIndex = i * n + length % n;
            }

            String substring = my_str.substring(i * n, endIndex);
            answer[i] = substring;
        }

        return answer;
    }
}
