package PS_Level1.개인정보수집유효기간;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int[] dates = new int[3];
        String[] todayArr = today.split("[.]");

        // 오늘 날짜 구하기
        int todayCount = getDateCount(Integer.parseInt(todayArr[0]), Integer.parseInt(todayArr[1]), Integer.parseInt(todayArr[2]));

        // key : 약관 종류, value : 유효기간 -> 저장
        for (String str : terms) {
            String[] arr = str.split(" ");
            map.put(arr[0], Integer.parseInt(arr[1]));
        }

        int index = 1;
        for (String privacy : privacies) {
            int idx = 0;
            String[] splitPrivacy = privacy.split(" ");

            // 개인정보 수집 일자 저장
            for (String date : splitPrivacy[0].split("[.]")) {
                dates[idx++] = Integer.parseInt(date);
            }

            // 개인정보 수집 일자에 약관 유효기간을 더해 총 유효기간 구하기
            int monthOfTerms = map.get(splitPrivacy[1]);
            dates[1] += monthOfTerms;
            int expirationDateCount = getDateCount(dates[0], dates[1], dates[2]);

            // 오늘 날짜가 유효기간을 지났으면 폐기해야하는 개인정보
            if (todayCount >= expirationDateCount) {
                list.add(index);
            }

            index++;
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    // 연, 월, 일을 이용해 총 날짜 카운트 구하기
    private static int getDateCount(int year, int month, int day) {
        return (year * 12 * 28) + (month * 28) + day;
    }
}