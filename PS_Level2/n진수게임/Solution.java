package PS_Level2.n진수게임;

// https://school.programmers.co.kr/learn/courses/30/lessons/17687
class Solution {
    // n : 진법, t : 미리 구할 숫자의 갯수, m : 게임에 참가하는 인원 수, p : 튜브의 순서
    // 출력 : 튜브의 순서에 말해야 하는 숫자를 t개 만큼
    public String solution(int n, int t, int m, int p) {
        StringBuilder builder = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int start = 0;
        // 전체 출력문 만들기
        while (builder.length() < t * m) {
            builder.append(Integer.toString(start++, n));
        }

        // 순서에 맞는 숫자만 추가하기
        for (int i = p - 1; i < t * m; i += m) {
            answer.append(builder.charAt(i));
        }

        return answer.toString().toUpperCase();
    }
}