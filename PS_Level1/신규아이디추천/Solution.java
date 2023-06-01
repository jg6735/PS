package PS_Level1.신규아이디추천;

// https://school.programmers.co.kr/learn/courses/30/lessons/72410
public class Solution {
    public String solution(String new_id) {
        // 1단계 : 대문자 -> 소문자
        String first = new_id.toLowerCase();

        // 2단계 : 소문자, 숫자, -, _, .를 제외한 모든 문자 제거
        String second = first.replaceAll("[^a-z0-9-_.]", "");

        // 3단계 : 연속된 마침표 .. -> 하나의 마침표 .
        String third = second.replace("..", ".");
        while (third.indexOf("..") >= 0) {
            third = third.replace("..", ".");
        }

        StringBuilder builder = new StringBuilder(third);

        // 4단계 : 마침표가 처음이나 끝에 위치하면 제거
        if (builder.indexOf(".") == 0) {
            builder.deleteCharAt(0);
        }

        if (builder.indexOf(".") == builder.length()) {
            builder.deleteCharAt(builder.length() - 1);
        }

        // 5단계 : 빈 문자열이면 a 대입
        if (builder.length() == 0) {
            builder.append("a");
        }

        // 6단계 : 16자 이상이면 첫 15개의 문자 제외 모두 제거
        if (builder.length() >= 16) {
            builder.setLength(15);
        }

        // 마침표가 끝에 위치하면 마침표 . 제거
        if (builder.charAt(builder.length() - 1) == '.') {
            builder.setLength(builder.length() - 1);
        }

        // 7단계 : 길이가 2자 이하라면, 마지막 문자를 길이가 3 될 때까지 반복해서 붙이기
        while (builder.length() < 3) {
            builder.append(builder.charAt(builder.length() - 1));
        }

        return builder.toString();
    }
}
