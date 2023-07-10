package PS_Level2.순위검색;

import java.util.*;
import java.util.function.Consumer;

// https://school.programmers.co.kr/learn/courses/30/lessons/72412
class Solution {
    // 만들 수 있는 모든 조건 완전 탐색
    private void forEachKey(int index, String prefix, String[] tokens,
                            Consumer<String> action) {
        if (index == tokens.length - 1) {
            action.accept(prefix);
            return;
        }

        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }

    // 조건별 리스트 만들기
    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }

        return scoresMap;
    }

    // 이진 탐색으로 가장 작은 값의 인덱스 찾기
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (scores.get(start) < score) {
            return scores.size();
        }

        return start;
    }

    // 조건에 맞는 지원자 수 세기
    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) {
            return 0;
        }

        List<Integer> scores = scoresMap.get(key);

        int score = Integer.parseInt(tokens[tokens.length - 1]);
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }

    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        int[] answer = new int[query.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = count(query[i], scoresMap);
        }

        return answer;
    }
}