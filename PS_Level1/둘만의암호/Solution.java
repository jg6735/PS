package PS_Level1.둘만의암호;

// https://school.programmers.co.kr/learn/courses/30/lessons/155652
class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder builder = new StringBuilder();
        int[] arr = new int['z' + 1];

        for (char c : s.toCharArray()) {
            arr[c]++;
        }

        for (char c : skip.toCharArray()) {
            arr[c]--;
        }

        int idx = 0;
        int count = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            idx = s.charAt(i);
            count = 0;
            temp = index;

            if (arr[idx] < 1) {
                continue;
            }

            while (count < temp) {
                if (idx + 1 > 'z') {
                    idx = (idx + 1) - 26;
                } else {
                    idx++;
                }

                if (arr[idx] == -1) {
                    temp++;
                }

                count++;
            }

            builder.append((char) idx);
        }

        return builder.toString();
    }
}