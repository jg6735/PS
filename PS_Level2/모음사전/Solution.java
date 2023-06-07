package PS_Level2.모음사전;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/84512
class Solution {
    private static final char[] WORDS = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        List<String> list = new ArrayList<>();
        recursion("", list);
        return list.indexOf(word);
    }

    private static List<String> recursion(String word, List<String> list) {
        list.add(word);

        if (word.length() == 5) {
            return list;
        }

        for (char c : WORDS) {
            recursion(word + c, list);
        }

        return list;
    }
}