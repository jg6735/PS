package PS_Level2.전화번호목록;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> set = new HashSet<>();
        Collections.addAll(set, phone_book);

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                if (set.contains(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return answer;
    }
}