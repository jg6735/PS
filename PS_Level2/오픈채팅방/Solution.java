package PS_Level2.오픈채팅방;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42888
class Solution {
    private static class User {
        private String nickname;

        public User(String nickname) {
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        private void change(String newNickName) {
            this.nickname = newNickName;
        }
    }

    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";
    private static final String ENTER_MESSAGE = "님이 들어왔습니다.";
    private static final String LEAVE_MESSAGE = "님이 나갔습니다.";

    private static boolean setUserList(Map<String, User> map, String[] userRecords) {
        if (userRecords[0].equals(ENTER)) {
            map.put(userRecords[1], new User(userRecords[2]));
        } else if (userRecords[0].equals(CHANGE)) {
            if (map.get(userRecords[1]).getNickname() != null) {
                map.get(userRecords[1]).change(userRecords[2]);
            } else {
                map.put(userRecords[1], new User(userRecords[2]));
            }

            return true;
        }

        return false;
    }

    private static String[] getMessage(String[] record, Map<String, User> map, String[] answer) {
        int index = 0;
        StringBuilder builder = new StringBuilder();
        for (String userRecord : record) {
            String[] userRecords = userRecord.split(" ");
            if (userRecords[0].equals(ENTER)) {
                answer[index++] = builder.append(map.get(userRecords[1]).getNickname())
                        .append(ENTER_MESSAGE)
                        .toString();
            } else if (userRecords[0].equals(LEAVE)) {
                answer[index++] = builder.append(map.get(userRecords[1]).getNickname())
                        .append(LEAVE_MESSAGE)
                        .toString();
            }

            builder.setLength(0);
        }

        return answer;
    }

    public String[] solution(String[] record) {
        Map<String, User> map = new HashMap<>();

        int length = 0;
        for (String userRecord : record) {
            String[] userRecords = userRecord.split(" ");
            if (setUserList(map, userRecords)) {
                continue;
            }

            length++;
        }

        String[] answer = new String[length];
        return getMessage(record, map, answer);
    }
}