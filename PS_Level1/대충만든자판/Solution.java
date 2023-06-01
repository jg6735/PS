package PS_Level1.대충만든자판;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/160586
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();
        int[] answer = new int[targets.length];

        // 문자를 작성할 수 있는 가장 적은 횟수를 저장
        for (String str : keymap) {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                // 이미 더 작은 인덱스로 키값을 저장하고 있으면 pass
                if (map.containsKey(c) && map.get(c) < i) {
                    continue;
                }

                map.put(c, i);
            }
        }

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                // 자판에 해당되는 키가 없으면 pass
                if (!map.containsKey(c)) {
                    answer[i] = -1;
                    break;
                }

                answer[i] += map.get(c) + 1;
            }
        }

        return answer;
    }
}