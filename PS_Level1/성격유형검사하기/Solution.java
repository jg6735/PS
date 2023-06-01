package PS_Level1.성격유형검사하기;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/118666
public class Solution {
    public String solution(String[] survey, int[] choices) {
        char[][] characteristics = new char[][]{
                {'R', 'T'},
                {'C', 'F'},
                {'J', 'M'},
                {'A', 'N'}
        };

        StringBuilder builder = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char[] characteristic : characteristics) {
            map.put(characteristic[0], 0);
            map.put(characteristic[1], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char disagreement = survey[i].charAt(0);
            char agreement = survey[i].charAt(1);
            int choice = choices[i];

            if (choice > 4) {
                map.put(agreement, map.get(agreement) + (choice - 4));
            } else if (choice < 4) {
                map.put(disagreement, map.get(disagreement) + (4 - choice));
            }
        }

        for (char[] characteristic : characteristics) {
            Integer first = map.get(characteristic[0]);
            Integer second = map.get(characteristic[1]);

            if (first >= second) {
                builder.append(characteristic[0]);
            } else {
                builder.append(characteristic[1]);
            }
        }

        return builder.toString();
    }
}
