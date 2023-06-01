package PS_Level1.달리기경주;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/178871
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i + 1);
        }

        for (String calling : callings) {
            if (map.get(calling) == 1) {
                continue;
            }

            String player = players[map.get(calling) - 2];
            int rank = map.get(player);
            players[map.get(calling) - 2] = calling;
            players[rank] = player;
            map.put(calling, map.get(calling) - 1);
            map.put(player, rank + 1);
        }

        return players;
    }
}