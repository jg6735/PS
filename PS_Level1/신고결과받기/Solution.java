package PS_Level1.신고결과받기;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, User> userHashMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            userHashMap.put(id_list[i], new User(id_list[i], 0, false, new HashSet<>()));
        }

        for (int i = 0; i < report.length; i++) {
            String userId = report[i].split(" ")[0]; // 이용자 ID
            String reportedUserId = report[i].split(" ")[1]; // 신고한 ID
            User user = userHashMap.get(userId); // 신고한 유저
            User reportedUser = userHashMap.get(reportedUserId); // 신고된 유저

            // 신고 목록에 신고된 유저가 없으면 신고하기
            if (!user.getReportList().contains(reportedUser)) {
                user.report(reportedUser);
                reportedUser.reported();

                // 신고된 유저의 신고 당한 횟수가 k회가 넘으면 정지
                if (reportedUser.getReportedCount() >= k) {
                    reportedUser.banned();
                }
            }
        }

        for (int i = 0; i < answer.length; i++) {
            Set<User> set = userHashMap.get(id_list[i]).getReportList(); // 해당 유저의 신고 목록
            for (User user : set) {
                // 정지된 유저면 카운팅
                if (user.isBanStatus()) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}

class User {
    private String userId;
    private int reportedCount;
    private boolean banStatus;
    private Set<User> reportList;

    public User(String userId, int reportedCount, boolean banStatus, Set<User> reportList) {
        this.userId = userId;
        this.reportedCount = reportedCount;
        this.banStatus = banStatus;
        this.reportList = reportList;
    }

    public String getUserId() {
        return userId;
    }

    public int getReportedCount() {
        return reportedCount;
    }

    public boolean isBanStatus() {
        return banStatus;
    }

    public Set<User> getReportList() {
        return reportList;
    }

    public void report(User user) {
        reportList.add(user);
    }

    public void reported() {
        reportedCount++;
    }

    public void banned() {
        banStatus = true;
    }
}