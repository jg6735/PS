package PS_Level2.가장큰수;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42746
class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        // 문자열로 저장
        for (int i = 0; i < nums.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        // 각 문자(숫자)를 이어붙였을 때 큰 숫자부터 내림차순 정렬
        Arrays.sort(nums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        // 가장 큰 문자(숫자)가 0일 경우 0... 이므로 0보다 큰 숫자를 만들 수 없음
        if (nums[0].equals("0")) {
            return nums[0];
        }

        StringBuilder builder = new StringBuilder();
        for (String num : nums) {
            builder.append(num);
        }

        return builder.toString();
    }
}