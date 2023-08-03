package PS_Level2.뉴스클러스터링;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/17677
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();
        setList(str1, list1);
        setList(str2, list2);

        for (String str : list1) {
            if (list2.remove(str)) {
                intersection.add(str);
            }

            union.add(str);
        }

        union.addAll(list2);
        if (union.isEmpty()) {
            return 0;
        }

        return (int) ((double) intersection.size() / union.size() * 65536);
    }

    private static void setList(String str, List<String> list1) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i + 1))) {
                list1.add(str.charAt(i) + String.valueOf(str.charAt(i + 1)));
            }
        }
    }
}