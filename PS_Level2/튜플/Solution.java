package PS_Level2.튜플;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public int[] solution2(String s) {
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String group = matcher.group();
            map.put(group, map.getOrDefault(group, 0) + 1);
        }

        int[] answer = new int[map.size()];
        for (Map.Entry<String, Integer> key : map.entrySet()) {
            answer[map.size() - key.getValue()] = Integer.parseInt(key.getKey());
        }

        return answer;
    }
}