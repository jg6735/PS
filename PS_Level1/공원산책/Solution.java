package PS_Level1.공원산책;

public class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        char[][] map = new char[park.length][park[0].length()];

        int x = 0;
        int y = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                map[i][j] = park[i].charAt(j);

                if (map[i][j] == 'S') {
                    x = j;
                    y = i;
                }
            }
        }

        String[] arr;
        String op;
        int n;
        for (int i = 0; i < routes.length; i++) {
            arr = routes[i].split(" ");
            op = arr[0];
            n = Integer.parseInt(arr[1]);
            boolean check = true;

            if (op.equals("N")) {
                if (y - n < 0) {
                    continue;
                }

                for (int d = 1; d <= n; d++) {
                    if (map[y - d][x] == 'X') {
                        check = false;
                    }
                }

                if (!check) {
                    continue;
                }

                y = y - n;
            } else if (op.equals("E")) {
                if (x + n >= park[0].length()) {
                    continue;
                }

                for (int d = 1; d <= n; d++) {
                    if (map[y][x + d] == 'X') {
                        check = false;
                    }
                }

                if (!check) {
                    continue;
                }

                x = x + n;
            } else if (op.equals("S")) {
                if (y + n >= park.length) {
                    continue;
                }

                for (int d = 1; d <= n; d++) {
                    if (map[y + d][x] == 'X') {
                        check = false;
                    }
                }

                if (!check) {
                    continue;
                }

                y = y + n;
            } else {
                if (x - n < 0) {
                    continue;
                }

                for (int d = 1; d <= n; d++) {
                    if (map[y][x - d] == 'X') {
                        check = false;
                    }
                }

                if (!check) {
                    continue;
                }

                x = x - n;
            }
        }

        answer[0] = y;
        answer[1] = x;

        return answer;
    }

}
