package PS_Level1.완주하지못한선수;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : participant) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.replace(str, map.get(str) + 1);
            }
        }

        for (String str : completion) {
            if (map.get(str) == 1) {
                map.remove(str);
            } else {
                map.replace(str, map.get(str) - 1);
            }
        }

        return map.keySet().iterator().next();
    }
}
