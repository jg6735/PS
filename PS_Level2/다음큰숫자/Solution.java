package PS_Level2.다음큰숫자;

// https://school.programmers.co.kr/learn/courses/30/lessons/12911
class Solution {
    public int solution(int n) {
        int answer = 0;

        int length = Integer.toBinaryString(n).replace("0", "").length();
        for (int i = n + 1; ; i++) {
            String binaryString = Integer.toBinaryString(i).replace("0", "");

            if (binaryString.length() == length) {
                answer = i;
                break;
            }
        }

        return answer;
    }
}