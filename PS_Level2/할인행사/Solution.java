package PS_Level2.할인행사;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://school.programmers.co.kr/learn/courses/30/lessons/131127
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            int count = 0;
            for (int j = i; j < i + 10; j++) {
                discountMap.put(discount[j], discountMap.getOrDefault(discount[j], 0) + 1);
            }

            for (String str : want) {
                if (Objects.equals(wantMap.get(str), discountMap.get(str))) {
                    count++;
                }
            }

            if (count == number.length) {
                answer++;
            }

            discountMap.clear();
        }

        return answer;
    }
}