package PS_Level0.숨어있는숫자의덧셈2;

public class Solution {
    public int solution(String my_string) {
        int answer = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < my_string.length(); i++) {
            if (!(my_string.charAt(i) - '0' >= 0 && my_string.charAt(i) - '0' <= 9)) {
                continue;
            }

            while (true) {
                if (i < my_string.length() && my_string.charAt(i) - '0' >= 0 && my_string.charAt(i) - '0' <= 9) {
                    builder.append(my_string.charAt(i) - '0');
                    i++;
                } else {
                    break;
                }
            }

            builder.append(" ");
        }

        if (builder.length() == 0) {
            return 0;
        }

        String[] arr = builder.toString().split(" ");
        for (String str : arr) {
            answer += Integer.parseInt(str);
        }

        return answer;
    }
}
