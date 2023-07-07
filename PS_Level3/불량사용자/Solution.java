package PS_Level3.불량사용자;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://school.programmers.co.kr/learn/courses/30/lessons/64064
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        // 불량 사용자 아이디 목록
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);
        return banSet.size();
    }

    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet) {
        // 기저 조건 모든 사용자 아이디 선택
        if (index == bans.length) {
            banSet.add(new HashSet<>(banned));
            return;
        }

        // 조합
        for (String id : bans[index]) {
            if (banned.contains(id)) {
                continue;
            }

            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }
}