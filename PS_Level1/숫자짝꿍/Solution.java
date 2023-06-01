package PS_Level1.숫자짝꿍;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/131128#
public class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder builder = new StringBuilder();

        Map<Integer, Integer> map = new HashMap<>();
        for (char c : X.toCharArray()) {
            map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
        }

        for (char c : Y.toCharArray()) {
            if (map.getOrDefault(c - '0', 0) != 0) {
                map.put(c - '0', map.get(c - '0') - 1);
                builder.append(c - '0');
            }
        }

        if (builder.length() == 0) {
            return "-1";
        } else {
            if (builder.charAt(0) == '0') {
                return "0";
            }

            String[] split = builder.toString().split("");
            Arrays.sort(split, Collections.reverseOrder());
            answer = String.join("", split);
        }

        return answer;
    }
}
