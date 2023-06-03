package PS_Level2.게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/1844
class Solution {
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};
    private boolean[][] visited;
    private int answer = -1;

    public int solution(int[][] maps) {

        visited = new boolean[maps.length][maps[0].length];
        bfs(new Coordinate(0, 0, 1), maps);

        return answer;
    }

    private void bfs(Coordinate coordinate, int[][] maps) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(coordinate);
        visited[coordinate.getY()][coordinate.getX()] = true;

        while (!queue.isEmpty()) {
            Coordinate cur = queue.poll();
            int curX = cur.getX();
            int curY = cur.getY();
            int distance = cur.getDistance();

            if (curX == visited[0].length - 1 && curY == visited.length - 1) {
                answer = distance;
            }

            for (int d = 0; d < 4; d++) {
                int nextX = dx[d] + curX;
                int nextY = dy[d] + curY;

                if (nextX < 0 || nextY < 0 || nextX >= visited[0].length || nextY >= visited.length) {
                    continue;
                }

                if (!visited[nextY][nextX] && maps[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.offer(new Coordinate(nextX, nextY, distance + 1));
                }
            }
        }
    }

    static class Coordinate {
        private final int x;
        private final int y;
        private final int distance;

        public Coordinate(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }
    }
}