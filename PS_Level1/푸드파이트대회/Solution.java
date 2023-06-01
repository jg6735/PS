package PS_Level1.푸드파이트대회;

// https://school.programmers.co.kr/learn/courses/30/lessons/134240
public class Solution {
    public String solution(int[] food) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            builder.append(String.valueOf(i).repeat(food[i] / 2));
        }

        return builder.toString() + "0" + builder.reverse();
    }
}
