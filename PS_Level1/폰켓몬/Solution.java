package PS_Level1.폰켓몬;

import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int n = nums.length / 2;

        return set.size() >= n ? n : set.size();
    }
}
