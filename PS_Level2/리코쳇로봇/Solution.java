package PS_Level2.리코쳇로봇;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199
class Solution {
    private static class Point {
        private final int x;
        private final int y;
        private final int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int bfs(Point start, char[][] map, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        visited[start.getY()][start.getX()] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            int curX = cur.getX();
            int curY = cur.getY();
            int count = cur.getCount();

            if (map[curY][curX] == 'G') {
                return count;
            }

            for (int d = 0; d < 4; d++) {
                int nextX = cur.getX();
                int nextY = cur.getY();

                while (isAvailable(map, nextX + dx[d], nextY + dy[d])) {
                    nextX += dx[d];
                    nextY += dy[d];
                }

                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.add(new Point(nextX, nextY, count + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isAvailable(char[][] map, int x, int y) {
        return x >= 0 && y < map.length && x < map[0].length && y >= 0 && map[y][x] != 'D';
    }

    public int solution(String[] board) {
        char[][] map = new char[board.length][board[0].length()];
        Point start = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                map[i][j] = board[i].charAt(j);

                if (map[i][j] == 'R') {
                    start = new Point(j, i, 0);
                }
            }
        }

        return bfs(start, map, new boolean[map.length][map[0].length]);
    }
}