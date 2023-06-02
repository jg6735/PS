package PS_Level2.미로탈출;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/159993
class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static Coordinate start = null;
    private static boolean isLeverPulled = false;
    private static int answer = -1;

    public int solution(String[] maps) {
        Coordinate[][] map = new Coordinate[maps.length][maps[0].length()]; // 미로 배열
        boolean[][] visited = new boolean[maps.length][maps[0].length()]; // 방문 체크용 배열

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                map[i][j] = new Coordinate(j, i, 0, c);

                // 'S'인 경우 시작 지점이므로 좌표에 입력해준다.
                if (c == 'S') {
                    start = new Coordinate(j, i, 0, c);
                }
            }
        }

        // 레버까지 탐색
        bfs(start, map, visited);

        if (answer == -1) {
            return answer;
        }

        // 레버부터 출구까지 탐색(방문 체크 초기화)
        bfs(start, map, new boolean[maps.length][maps[0].length()]);

        return answer;
    }

    private static void bfs(Coordinate coordinate, Coordinate[][] map, boolean[][] visited) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(coordinate);
        visited[coordinate.getY()][coordinate.getX()] = true;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curX = cur.getX();
            int curY = cur.getY();
            int time = cur.getTime();
            char curC = cur.getC();

            // 레버를 당기지 않았고, 현재 좌표가 레버라면 레버 당기기
            if (!isLeverPulled && curC == 'L') {
                answer = time;
                // 다음 탐색을 위해 레버의 위치를 시작 좌표로 저장
                start = new Coordinate(curX, curY, time, curC);
                // 레버 당기기
                isLeverPulled = true;
                break;
            }

            // 레버를 당긴 후 출구에 도착했다면
            if (isLeverPulled && curC == 'E') {
                answer = time;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextX = curX + dx[d];
                int nextY = curY + dy[d];

                // 미로 범위를 벗어나면 pass
                if (nextX < 0 || nextY < 0 || nextX >= map[0].length || nextY >= map.length) {
                    continue;
                }

                // 벽이 아니고 방문한 좌표가 아니라면 진행
                if (map[nextY][nextX].getC() != 'X' && !visited[nextY][nextX]) {
                    queue.offer(new Coordinate(nextX, nextY, time + 1, map[nextY][nextX].getC()));
                    visited[nextY][nextX] = true;
                }
            }

            answer = -1;
        }
    }

    static class Coordinate {
        private int x;
        private int y;
        private int time;
        private char c;

        public Coordinate(int x, int y, int time, char c) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.c = c;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getTime() {
            return time;
        }

        public char getC() {
            return c;
        }
    }
}