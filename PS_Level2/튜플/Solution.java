package PS_Level2.튜플;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/64065
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String replace = s.replace("{", "").replace("}", "");
        String[] split = replace.split(",");
        for (String str : split) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int[] answer = new int[map.size()];
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2) - map.get(o1));
        int index = 0;
        for (String str : list) {
            answer[index++] = Integer.parseInt(str);
        }

        return answer;
    }
}