package PS_Level1.문자열내마음대로정렬하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// https://school.programmers.co.kr/learn/courses/30/lessons/12915
public class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

/*        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < strings.length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).substring(1);
        }*/

        Arrays.sort(strings, (o1, o2) -> {
            if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            } else {
                return o1.charAt(n) - o2.charAt(n);
            }
        });

        return strings;
    }
}
